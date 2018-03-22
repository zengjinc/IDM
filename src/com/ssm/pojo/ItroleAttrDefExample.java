package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class ItroleAttrDefExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItroleAttrDefExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andItroleAttrDefKeyIsNull() {
            addCriterion("itrole_attr_def_key is null");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefKeyIsNotNull() {
            addCriterion("itrole_attr_def_key is not null");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefKeyEqualTo(String value) {
            addCriterion("itrole_attr_def_key =", value, "itroleAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefKeyNotEqualTo(String value) {
            addCriterion("itrole_attr_def_key <>", value, "itroleAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefKeyGreaterThan(String value) {
            addCriterion("itrole_attr_def_key >", value, "itroleAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefKeyGreaterThanOrEqualTo(String value) {
            addCriterion("itrole_attr_def_key >=", value, "itroleAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefKeyLessThan(String value) {
            addCriterion("itrole_attr_def_key <", value, "itroleAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefKeyLessThanOrEqualTo(String value) {
            addCriterion("itrole_attr_def_key <=", value, "itroleAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefKeyLike(String value) {
            addCriterion("itrole_attr_def_key like", value, "itroleAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefKeyNotLike(String value) {
            addCriterion("itrole_attr_def_key not like", value, "itroleAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefKeyIn(List<String> values) {
            addCriterion("itrole_attr_def_key in", values, "itroleAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefKeyNotIn(List<String> values) {
            addCriterion("itrole_attr_def_key not in", values, "itroleAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefKeyBetween(String value1, String value2) {
            addCriterion("itrole_attr_def_key between", value1, value2, "itroleAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefKeyNotBetween(String value1, String value2) {
            addCriterion("itrole_attr_def_key not between", value1, value2, "itroleAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefNameIsNull() {
            addCriterion("itrole_attr_def_name is null");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefNameIsNotNull() {
            addCriterion("itrole_attr_def_name is not null");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefNameEqualTo(String value) {
            addCriterion("itrole_attr_def_name =", value, "itroleAttrDefName");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefNameNotEqualTo(String value) {
            addCriterion("itrole_attr_def_name <>", value, "itroleAttrDefName");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefNameGreaterThan(String value) {
            addCriterion("itrole_attr_def_name >", value, "itroleAttrDefName");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefNameGreaterThanOrEqualTo(String value) {
            addCriterion("itrole_attr_def_name >=", value, "itroleAttrDefName");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefNameLessThan(String value) {
            addCriterion("itrole_attr_def_name <", value, "itroleAttrDefName");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefNameLessThanOrEqualTo(String value) {
            addCriterion("itrole_attr_def_name <=", value, "itroleAttrDefName");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefNameLike(String value) {
            addCriterion("itrole_attr_def_name like", value, "itroleAttrDefName");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefNameNotLike(String value) {
            addCriterion("itrole_attr_def_name not like", value, "itroleAttrDefName");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefNameIn(List<String> values) {
            addCriterion("itrole_attr_def_name in", values, "itroleAttrDefName");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefNameNotIn(List<String> values) {
            addCriterion("itrole_attr_def_name not in", values, "itroleAttrDefName");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefNameBetween(String value1, String value2) {
            addCriterion("itrole_attr_def_name between", value1, value2, "itroleAttrDefName");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefNameNotBetween(String value1, String value2) {
            addCriterion("itrole_attr_def_name not between", value1, value2, "itroleAttrDefName");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefDatatypeIsNull() {
            addCriterion("itrole_attr_def_datatype is null");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefDatatypeIsNotNull() {
            addCriterion("itrole_attr_def_datatype is not null");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefDatatypeEqualTo(String value) {
            addCriterion("itrole_attr_def_datatype =", value, "itroleAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefDatatypeNotEqualTo(String value) {
            addCriterion("itrole_attr_def_datatype <>", value, "itroleAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefDatatypeGreaterThan(String value) {
            addCriterion("itrole_attr_def_datatype >", value, "itroleAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefDatatypeGreaterThanOrEqualTo(String value) {
            addCriterion("itrole_attr_def_datatype >=", value, "itroleAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefDatatypeLessThan(String value) {
            addCriterion("itrole_attr_def_datatype <", value, "itroleAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefDatatypeLessThanOrEqualTo(String value) {
            addCriterion("itrole_attr_def_datatype <=", value, "itroleAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefDatatypeLike(String value) {
            addCriterion("itrole_attr_def_datatype like", value, "itroleAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefDatatypeNotLike(String value) {
            addCriterion("itrole_attr_def_datatype not like", value, "itroleAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefDatatypeIn(List<String> values) {
            addCriterion("itrole_attr_def_datatype in", values, "itroleAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefDatatypeNotIn(List<String> values) {
            addCriterion("itrole_attr_def_datatype not in", values, "itroleAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefDatatypeBetween(String value1, String value2) {
            addCriterion("itrole_attr_def_datatype between", value1, value2, "itroleAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefDatatypeNotBetween(String value1, String value2) {
            addCriterion("itrole_attr_def_datatype not between", value1, value2, "itroleAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMandatoryIsNull() {
            addCriterion("itrole_attr_def_mandatory is null");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMandatoryIsNotNull() {
            addCriterion("itrole_attr_def_mandatory is not null");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMandatoryEqualTo(Integer value) {
            addCriterion("itrole_attr_def_mandatory =", value, "itroleAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMandatoryNotEqualTo(Integer value) {
            addCriterion("itrole_attr_def_mandatory <>", value, "itroleAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMandatoryGreaterThan(Integer value) {
            addCriterion("itrole_attr_def_mandatory >", value, "itroleAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMandatoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("itrole_attr_def_mandatory >=", value, "itroleAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMandatoryLessThan(Integer value) {
            addCriterion("itrole_attr_def_mandatory <", value, "itroleAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMandatoryLessThanOrEqualTo(Integer value) {
            addCriterion("itrole_attr_def_mandatory <=", value, "itroleAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMandatoryIn(List<Integer> values) {
            addCriterion("itrole_attr_def_mandatory in", values, "itroleAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMandatoryNotIn(List<Integer> values) {
            addCriterion("itrole_attr_def_mandatory not in", values, "itroleAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMandatoryBetween(Integer value1, Integer value2) {
            addCriterion("itrole_attr_def_mandatory between", value1, value2, "itroleAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMandatoryNotBetween(Integer value1, Integer value2) {
            addCriterion("itrole_attr_def_mandatory not between", value1, value2, "itroleAttrDefMandatory");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefEditableIsNull() {
            addCriterion("itrole_attr_def_editable is null");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefEditableIsNotNull() {
            addCriterion("itrole_attr_def_editable is not null");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefEditableEqualTo(Integer value) {
            addCriterion("itrole_attr_def_editable =", value, "itroleAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefEditableNotEqualTo(Integer value) {
            addCriterion("itrole_attr_def_editable <>", value, "itroleAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefEditableGreaterThan(Integer value) {
            addCriterion("itrole_attr_def_editable >", value, "itroleAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefEditableGreaterThanOrEqualTo(Integer value) {
            addCriterion("itrole_attr_def_editable >=", value, "itroleAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefEditableLessThan(Integer value) {
            addCriterion("itrole_attr_def_editable <", value, "itroleAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefEditableLessThanOrEqualTo(Integer value) {
            addCriterion("itrole_attr_def_editable <=", value, "itroleAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefEditableIn(List<Integer> values) {
            addCriterion("itrole_attr_def_editable in", values, "itroleAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefEditableNotIn(List<Integer> values) {
            addCriterion("itrole_attr_def_editable not in", values, "itroleAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefEditableBetween(Integer value1, Integer value2) {
            addCriterion("itrole_attr_def_editable between", value1, value2, "itroleAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefEditableNotBetween(Integer value1, Integer value2) {
            addCriterion("itrole_attr_def_editable not between", value1, value2, "itroleAttrDefEditable");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMaxIsNull() {
            addCriterion("itrole_attr_def_max is null");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMaxIsNotNull() {
            addCriterion("itrole_attr_def_max is not null");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMaxEqualTo(String value) {
            addCriterion("itrole_attr_def_max =", value, "itroleAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMaxNotEqualTo(String value) {
            addCriterion("itrole_attr_def_max <>", value, "itroleAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMaxGreaterThan(String value) {
            addCriterion("itrole_attr_def_max >", value, "itroleAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMaxGreaterThanOrEqualTo(String value) {
            addCriterion("itrole_attr_def_max >=", value, "itroleAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMaxLessThan(String value) {
            addCriterion("itrole_attr_def_max <", value, "itroleAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMaxLessThanOrEqualTo(String value) {
            addCriterion("itrole_attr_def_max <=", value, "itroleAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMaxLike(String value) {
            addCriterion("itrole_attr_def_max like", value, "itroleAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMaxNotLike(String value) {
            addCriterion("itrole_attr_def_max not like", value, "itroleAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMaxIn(List<String> values) {
            addCriterion("itrole_attr_def_max in", values, "itroleAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMaxNotIn(List<String> values) {
            addCriterion("itrole_attr_def_max not in", values, "itroleAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMaxBetween(String value1, String value2) {
            addCriterion("itrole_attr_def_max between", value1, value2, "itroleAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMaxNotBetween(String value1, String value2) {
            addCriterion("itrole_attr_def_max not between", value1, value2, "itroleAttrDefMax");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMinIsNull() {
            addCriterion("itrole_attr_def_min is null");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMinIsNotNull() {
            addCriterion("itrole_attr_def_min is not null");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMinEqualTo(String value) {
            addCriterion("itrole_attr_def_min =", value, "itroleAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMinNotEqualTo(String value) {
            addCriterion("itrole_attr_def_min <>", value, "itroleAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMinGreaterThan(String value) {
            addCriterion("itrole_attr_def_min >", value, "itroleAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMinGreaterThanOrEqualTo(String value) {
            addCriterion("itrole_attr_def_min >=", value, "itroleAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMinLessThan(String value) {
            addCriterion("itrole_attr_def_min <", value, "itroleAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMinLessThanOrEqualTo(String value) {
            addCriterion("itrole_attr_def_min <=", value, "itroleAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMinLike(String value) {
            addCriterion("itrole_attr_def_min like", value, "itroleAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMinNotLike(String value) {
            addCriterion("itrole_attr_def_min not like", value, "itroleAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMinIn(List<String> values) {
            addCriterion("itrole_attr_def_min in", values, "itroleAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMinNotIn(List<String> values) {
            addCriterion("itrole_attr_def_min not in", values, "itroleAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMinBetween(String value1, String value2) {
            addCriterion("itrole_attr_def_min between", value1, value2, "itroleAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefMinNotBetween(String value1, String value2) {
            addCriterion("itrole_attr_def_min not between", value1, value2, "itroleAttrDefMin");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefResUuidIsNull() {
            addCriterion("itrole_attr_def_res_uuid is null");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefResUuidIsNotNull() {
            addCriterion("itrole_attr_def_res_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefResUuidEqualTo(String value) {
            addCriterion("itrole_attr_def_res_uuid =", value, "itroleAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefResUuidNotEqualTo(String value) {
            addCriterion("itrole_attr_def_res_uuid <>", value, "itroleAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefResUuidGreaterThan(String value) {
            addCriterion("itrole_attr_def_res_uuid >", value, "itroleAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefResUuidGreaterThanOrEqualTo(String value) {
            addCriterion("itrole_attr_def_res_uuid >=", value, "itroleAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefResUuidLessThan(String value) {
            addCriterion("itrole_attr_def_res_uuid <", value, "itroleAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefResUuidLessThanOrEqualTo(String value) {
            addCriterion("itrole_attr_def_res_uuid <=", value, "itroleAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefResUuidLike(String value) {
            addCriterion("itrole_attr_def_res_uuid like", value, "itroleAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefResUuidNotLike(String value) {
            addCriterion("itrole_attr_def_res_uuid not like", value, "itroleAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefResUuidIn(List<String> values) {
            addCriterion("itrole_attr_def_res_uuid in", values, "itroleAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefResUuidNotIn(List<String> values) {
            addCriterion("itrole_attr_def_res_uuid not in", values, "itroleAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefResUuidBetween(String value1, String value2) {
            addCriterion("itrole_attr_def_res_uuid between", value1, value2, "itroleAttrDefResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrDefResUuidNotBetween(String value1, String value2) {
            addCriterion("itrole_attr_def_res_uuid not between", value1, value2, "itroleAttrDefResUuid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}