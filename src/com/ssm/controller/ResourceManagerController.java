package com.ssm.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ssm.mapper.ResourceMapper;
import com.ssm.mapper.ResourceTypeMapper;
import com.ssm.pojo.Resource;
import com.ssm.pojo.ResourceExample;
import com.ssm.pojo.ResourceExample.Criteria;
import com.ssm.pojo.ResourceType;
import com.ssm.pojo.ResourceTypeExample;
import com.ssm.utils.CommonUtil;

@Controller
@RequestMapping("/toresource")
public class ResourceManagerController {

	private static Logger logger = LoggerFactory.getLogger(ResourceManagerController.class);

	@Autowired
	private ResourceTypeMapper resourceTypeMapper;

	@Autowired
	private ResourceMapper resourceMapper;

	@RequestMapping("/resource")
	public String toResource(ModelMap modelMap, @RequestParam(required = true, defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
		// List<Resource> resourceList = resourceMapper.selectByExample(null,new PageBounds()); //PageBounds参数为空的话，表示不分页，查询全部
		// 分页查询
		PageBounds pageBounds = new PageBounds(page, limit);
		ResourceExample example = new ResourceExample();
		example.setOrderByClause("res_id");
		List<Resource> pagedresourceList = resourceMapper.selectByExample(example , pageBounds);
		modelMap.put("resourceList", pagedresourceList);
		return "resource/resource";
	}

	@RequestMapping(value="/searchresource",  method=RequestMethod.POST)
	public String searchResource(ModelMap modelMap,@ModelAttribute Resource resource){
		String resId = resource.getResId();
		String resName = resource.getResName();
		
		PageBounds pageBounds = new PageBounds(1,10);
		ResourceExample example = new ResourceExample();
		Criteria criteria = example.createCriteria();
		
		if(resId != null && resId != ""){
			criteria.andResIdEqualTo(resId);
		}
		
		if(resName != null && resName != ""){
			criteria.andResNameLike("%" + resName + "%");
		}

		List<Resource> pagedresourceList = resourceMapper.selectByExample(example, pageBounds);
		modelMap.put("resourceList", pagedresourceList);
		return "resource/resource";
	}
	
	@RequestMapping("/deleteresource")
	public String deleteResource(@RequestParam(value="resuuid")String resUuid){
		resourceMapper.deleteByPrimaryKey(resUuid);
		return "redirect:resource.action";
	}
	
	@RequestMapping("/resourcedetail")
	public String toResourceDetail() {
		return "resource/resourcedetail";
	}
	
	@RequestMapping(value = "/testconnection", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, String> testConnection(@RequestBody Map<String, String> jdbcConfig) { // (@RequestBody
																								// 将传送的json转化为对象
		HashMap<String, String> result = new HashMap<>();
		Connection connection = null;

		String jdbcDrive = jdbcConfig.get("jdbc_drive");
		String jdbcUrl = jdbcConfig.get("jdbc_url");
		String jdbcUserName = jdbcConfig.get("jdbc_username");
		String jdbcPwd = jdbcConfig.get("jdbc_pwd");

		// 1.加载驱动程序
		try {
			Class.forName(jdbcDrive);
			connection = DriverManager.getConnection(jdbcUrl, jdbcUserName, jdbcPwd);
			Statement statement = connection.createStatement();
			
			result.put("result", "success");
		} catch (ClassNotFoundException e) {
			result.put("result", e.getMessage());
		} catch (SQLException e) {
			result.put("result", e.getMessage());
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					result.put("result", e.getMessage());
				}
			}
		}
		return result;
	}

	@RequestMapping(value = "/saveresource", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, String> saveResource(@RequestBody String jsonString) throws Exception { // (@RequestBody 将传送的json转化为对象
		HashMap<String, String> result = new HashMap<>();
		result.put("result", "success");

		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(jsonString);
		String resUuid = node.get("resUuid").asText();
		JsonNode baseJson = node.get("baseJson");
		JsonNode attrJson = node.get("attrJson");

		Resource resource = new Resource();
		resource.setResUuid(CommonUtil.generateUUID());
		resource.setResId(baseJson.get("resource_id").asText());
		resource.setResName(baseJson.get("resource_name").asText());
		resource.setResDesc(baseJson.get("resource_desc").asText());
		resource.setResTrust(baseJson.get("resource_trust").asText().equalsIgnoreCase("false") ? 0 : 1);
		ResourceTypeExample example = new ResourceTypeExample();
		example.createCriteria().andResTypeNameEqualTo(baseJson.get("resource_type").asText());
		List<ResourceType> selectByExample = resourceTypeMapper.selectByExample(example);
		resource.setResTypeUuid(selectByExample.get(0).getResTypeUuid());
		resource.setResJsonAttr(attrJson.toString());

		if(resUuid != null && resUuid != "null"){	//update
			resource.setResUuid(resUuid);
			resourceMapper.updateByPrimaryKeyWithBLOBs(resource);
			
		}else{									//insert
			if (resourceMapper.insert(resource) <= 0) {
				result.put("result", "failure");
			}
		}
		
		return result;
	}
	
	@RequestMapping(value = "/getresource", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Resource getResource(@RequestBody String jsonString) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		String resUuid = mapper.readTree(jsonString).asText();

		Resource resource = resourceMapper.selectByPrimaryKey(resUuid);
		
		return resource;
	}
	
}
