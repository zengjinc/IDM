package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class BusinessRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusinessRoleExample() {
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

        public Criteria andBizRoleUuidIsNull() {
            addCriterion("biz_role_uuid is null");
            return (Criteria) this;
        }

        public Criteria andBizRoleUuidIsNotNull() {
            addCriterion("biz_role_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andBizRoleUuidEqualTo(String value) {
            addCriterion("biz_role_uuid =", value, "bizRoleUuid");
            return (Criteria) this;
        }

        public Criteria andBizRoleUuidNotEqualTo(String value) {
            addCriterion("biz_role_uuid <>", value, "bizRoleUuid");
            return (Criteria) this;
        }

        public Criteria andBizRoleUuidGreaterThan(String value) {
            addCriterion("biz_role_uuid >", value, "bizRoleUuid");
            return (Criteria) this;
        }

        public Criteria andBizRoleUuidGreaterThanOrEqualTo(String value) {
            addCriterion("biz_role_uuid >=", value, "bizRoleUuid");
            return (Criteria) this;
        }

        public Criteria andBizRoleUuidLessThan(String value) {
            addCriterion("biz_role_uuid <", value, "bizRoleUuid");
            return (Criteria) this;
        }

        public Criteria andBizRoleUuidLessThanOrEqualTo(String value) {
            addCriterion("biz_role_uuid <=", value, "bizRoleUuid");
            return (Criteria) this;
        }

        public Criteria andBizRoleUuidLike(String value) {
            addCriterion("biz_role_uuid like", value, "bizRoleUuid");
            return (Criteria) this;
        }

        public Criteria andBizRoleUuidNotLike(String value) {
            addCriterion("biz_role_uuid not like", value, "bizRoleUuid");
            return (Criteria) this;
        }

        public Criteria andBizRoleUuidIn(List<String> values) {
            addCriterion("biz_role_uuid in", values, "bizRoleUuid");
            return (Criteria) this;
        }

        public Criteria andBizRoleUuidNotIn(List<String> values) {
            addCriterion("biz_role_uuid not in", values, "bizRoleUuid");
            return (Criteria) this;
        }

        public Criteria andBizRoleUuidBetween(String value1, String value2) {
            addCriterion("biz_role_uuid between", value1, value2, "bizRoleUuid");
            return (Criteria) this;
        }

        public Criteria andBizRoleUuidNotBetween(String value1, String value2) {
            addCriterion("biz_role_uuid not between", value1, value2, "bizRoleUuid");
            return (Criteria) this;
        }

        public Criteria andBizRoleIdIsNull() {
            addCriterion("biz_role_id is null");
            return (Criteria) this;
        }

        public Criteria andBizRoleIdIsNotNull() {
            addCriterion("biz_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andBizRoleIdEqualTo(String value) {
            addCriterion("biz_role_id =", value, "bizRoleId");
            return (Criteria) this;
        }

        public Criteria andBizRoleIdNotEqualTo(String value) {
            addCriterion("biz_role_id <>", value, "bizRoleId");
            return (Criteria) this;
        }

        public Criteria andBizRoleIdGreaterThan(String value) {
            addCriterion("biz_role_id >", value, "bizRoleId");
            return (Criteria) this;
        }

        public Criteria andBizRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("biz_role_id >=", value, "bizRoleId");
            return (Criteria) this;
        }

        public Criteria andBizRoleIdLessThan(String value) {
            addCriterion("biz_role_id <", value, "bizRoleId");
            return (Criteria) this;
        }

        public Criteria andBizRoleIdLessThanOrEqualTo(String value) {
            addCriterion("biz_role_id <=", value, "bizRoleId");
            return (Criteria) this;
        }

        public Criteria andBizRoleIdLike(String value) {
            addCriterion("biz_role_id like", value, "bizRoleId");
            return (Criteria) this;
        }

        public Criteria andBizRoleIdNotLike(String value) {
            addCriterion("biz_role_id not like", value, "bizRoleId");
            return (Criteria) this;
        }

        public Criteria andBizRoleIdIn(List<String> values) {
            addCriterion("biz_role_id in", values, "bizRoleId");
            return (Criteria) this;
        }

        public Criteria andBizRoleIdNotIn(List<String> values) {
            addCriterion("biz_role_id not in", values, "bizRoleId");
            return (Criteria) this;
        }

        public Criteria andBizRoleIdBetween(String value1, String value2) {
            addCriterion("biz_role_id between", value1, value2, "bizRoleId");
            return (Criteria) this;
        }

        public Criteria andBizRoleIdNotBetween(String value1, String value2) {
            addCriterion("biz_role_id not between", value1, value2, "bizRoleId");
            return (Criteria) this;
        }

        public Criteria andBizRoleNameIsNull() {
            addCriterion("biz_role_name is null");
            return (Criteria) this;
        }

        public Criteria andBizRoleNameIsNotNull() {
            addCriterion("biz_role_name is not null");
            return (Criteria) this;
        }

        public Criteria andBizRoleNameEqualTo(String value) {
            addCriterion("biz_role_name =", value, "bizRoleName");
            return (Criteria) this;
        }

        public Criteria andBizRoleNameNotEqualTo(String value) {
            addCriterion("biz_role_name <>", value, "bizRoleName");
            return (Criteria) this;
        }

        public Criteria andBizRoleNameGreaterThan(String value) {
            addCriterion("biz_role_name >", value, "bizRoleName");
            return (Criteria) this;
        }

        public Criteria andBizRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("biz_role_name >=", value, "bizRoleName");
            return (Criteria) this;
        }

        public Criteria andBizRoleNameLessThan(String value) {
            addCriterion("biz_role_name <", value, "bizRoleName");
            return (Criteria) this;
        }

        public Criteria andBizRoleNameLessThanOrEqualTo(String value) {
            addCriterion("biz_role_name <=", value, "bizRoleName");
            return (Criteria) this;
        }

        public Criteria andBizRoleNameLike(String value) {
            addCriterion("biz_role_name like", value, "bizRoleName");
            return (Criteria) this;
        }

        public Criteria andBizRoleNameNotLike(String value) {
            addCriterion("biz_role_name not like", value, "bizRoleName");
            return (Criteria) this;
        }

        public Criteria andBizRoleNameIn(List<String> values) {
            addCriterion("biz_role_name in", values, "bizRoleName");
            return (Criteria) this;
        }

        public Criteria andBizRoleNameNotIn(List<String> values) {
            addCriterion("biz_role_name not in", values, "bizRoleName");
            return (Criteria) this;
        }

        public Criteria andBizRoleNameBetween(String value1, String value2) {
            addCriterion("biz_role_name between", value1, value2, "bizRoleName");
            return (Criteria) this;
        }

        public Criteria andBizRoleNameNotBetween(String value1, String value2) {
            addCriterion("biz_role_name not between", value1, value2, "bizRoleName");
            return (Criteria) this;
        }

        public Criteria andBizRoleDescIsNull() {
            addCriterion("biz_role_desc is null");
            return (Criteria) this;
        }

        public Criteria andBizRoleDescIsNotNull() {
            addCriterion("biz_role_desc is not null");
            return (Criteria) this;
        }

        public Criteria andBizRoleDescEqualTo(String value) {
            addCriterion("biz_role_desc =", value, "bizRoleDesc");
            return (Criteria) this;
        }

        public Criteria andBizRoleDescNotEqualTo(String value) {
            addCriterion("biz_role_desc <>", value, "bizRoleDesc");
            return (Criteria) this;
        }

        public Criteria andBizRoleDescGreaterThan(String value) {
            addCriterion("biz_role_desc >", value, "bizRoleDesc");
            return (Criteria) this;
        }

        public Criteria andBizRoleDescGreaterThanOrEqualTo(String value) {
            addCriterion("biz_role_desc >=", value, "bizRoleDesc");
            return (Criteria) this;
        }

        public Criteria andBizRoleDescLessThan(String value) {
            addCriterion("biz_role_desc <", value, "bizRoleDesc");
            return (Criteria) this;
        }

        public Criteria andBizRoleDescLessThanOrEqualTo(String value) {
            addCriterion("biz_role_desc <=", value, "bizRoleDesc");
            return (Criteria) this;
        }

        public Criteria andBizRoleDescLike(String value) {
            addCriterion("biz_role_desc like", value, "bizRoleDesc");
            return (Criteria) this;
        }

        public Criteria andBizRoleDescNotLike(String value) {
            addCriterion("biz_role_desc not like", value, "bizRoleDesc");
            return (Criteria) this;
        }

        public Criteria andBizRoleDescIn(List<String> values) {
            addCriterion("biz_role_desc in", values, "bizRoleDesc");
            return (Criteria) this;
        }

        public Criteria andBizRoleDescNotIn(List<String> values) {
            addCriterion("biz_role_desc not in", values, "bizRoleDesc");
            return (Criteria) this;
        }

        public Criteria andBizRoleDescBetween(String value1, String value2) {
            addCriterion("biz_role_desc between", value1, value2, "bizRoleDesc");
            return (Criteria) this;
        }

        public Criteria andBizRoleDescNotBetween(String value1, String value2) {
            addCriterion("biz_role_desc not between", value1, value2, "bizRoleDesc");
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