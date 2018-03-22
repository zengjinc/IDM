package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class ItroleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItroleExample() {
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

        public Criteria andItroleUuidIsNull() {
            addCriterion("itrole_uuid is null");
            return (Criteria) this;
        }

        public Criteria andItroleUuidIsNotNull() {
            addCriterion("itrole_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andItroleUuidEqualTo(String value) {
            addCriterion("itrole_uuid =", value, "itroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleUuidNotEqualTo(String value) {
            addCriterion("itrole_uuid <>", value, "itroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleUuidGreaterThan(String value) {
            addCriterion("itrole_uuid >", value, "itroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleUuidGreaterThanOrEqualTo(String value) {
            addCriterion("itrole_uuid >=", value, "itroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleUuidLessThan(String value) {
            addCriterion("itrole_uuid <", value, "itroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleUuidLessThanOrEqualTo(String value) {
            addCriterion("itrole_uuid <=", value, "itroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleUuidLike(String value) {
            addCriterion("itrole_uuid like", value, "itroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleUuidNotLike(String value) {
            addCriterion("itrole_uuid not like", value, "itroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleUuidIn(List<String> values) {
            addCriterion("itrole_uuid in", values, "itroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleUuidNotIn(List<String> values) {
            addCriterion("itrole_uuid not in", values, "itroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleUuidBetween(String value1, String value2) {
            addCriterion("itrole_uuid between", value1, value2, "itroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleUuidNotBetween(String value1, String value2) {
            addCriterion("itrole_uuid not between", value1, value2, "itroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleIdIsNull() {
            addCriterion("itrole_id is null");
            return (Criteria) this;
        }

        public Criteria andItroleIdIsNotNull() {
            addCriterion("itrole_id is not null");
            return (Criteria) this;
        }

        public Criteria andItroleIdEqualTo(String value) {
            addCriterion("itrole_id =", value, "itroleId");
            return (Criteria) this;
        }

        public Criteria andItroleIdNotEqualTo(String value) {
            addCriterion("itrole_id <>", value, "itroleId");
            return (Criteria) this;
        }

        public Criteria andItroleIdGreaterThan(String value) {
            addCriterion("itrole_id >", value, "itroleId");
            return (Criteria) this;
        }

        public Criteria andItroleIdGreaterThanOrEqualTo(String value) {
            addCriterion("itrole_id >=", value, "itroleId");
            return (Criteria) this;
        }

        public Criteria andItroleIdLessThan(String value) {
            addCriterion("itrole_id <", value, "itroleId");
            return (Criteria) this;
        }

        public Criteria andItroleIdLessThanOrEqualTo(String value) {
            addCriterion("itrole_id <=", value, "itroleId");
            return (Criteria) this;
        }

        public Criteria andItroleIdLike(String value) {
            addCriterion("itrole_id like", value, "itroleId");
            return (Criteria) this;
        }

        public Criteria andItroleIdNotLike(String value) {
            addCriterion("itrole_id not like", value, "itroleId");
            return (Criteria) this;
        }

        public Criteria andItroleIdIn(List<String> values) {
            addCriterion("itrole_id in", values, "itroleId");
            return (Criteria) this;
        }

        public Criteria andItroleIdNotIn(List<String> values) {
            addCriterion("itrole_id not in", values, "itroleId");
            return (Criteria) this;
        }

        public Criteria andItroleIdBetween(String value1, String value2) {
            addCriterion("itrole_id between", value1, value2, "itroleId");
            return (Criteria) this;
        }

        public Criteria andItroleIdNotBetween(String value1, String value2) {
            addCriterion("itrole_id not between", value1, value2, "itroleId");
            return (Criteria) this;
        }

        public Criteria andItroleNameIsNull() {
            addCriterion("itrole_name is null");
            return (Criteria) this;
        }

        public Criteria andItroleNameIsNotNull() {
            addCriterion("itrole_name is not null");
            return (Criteria) this;
        }

        public Criteria andItroleNameEqualTo(String value) {
            addCriterion("itrole_name =", value, "itroleName");
            return (Criteria) this;
        }

        public Criteria andItroleNameNotEqualTo(String value) {
            addCriterion("itrole_name <>", value, "itroleName");
            return (Criteria) this;
        }

        public Criteria andItroleNameGreaterThan(String value) {
            addCriterion("itrole_name >", value, "itroleName");
            return (Criteria) this;
        }

        public Criteria andItroleNameGreaterThanOrEqualTo(String value) {
            addCriterion("itrole_name >=", value, "itroleName");
            return (Criteria) this;
        }

        public Criteria andItroleNameLessThan(String value) {
            addCriterion("itrole_name <", value, "itroleName");
            return (Criteria) this;
        }

        public Criteria andItroleNameLessThanOrEqualTo(String value) {
            addCriterion("itrole_name <=", value, "itroleName");
            return (Criteria) this;
        }

        public Criteria andItroleNameLike(String value) {
            addCriterion("itrole_name like", value, "itroleName");
            return (Criteria) this;
        }

        public Criteria andItroleNameNotLike(String value) {
            addCriterion("itrole_name not like", value, "itroleName");
            return (Criteria) this;
        }

        public Criteria andItroleNameIn(List<String> values) {
            addCriterion("itrole_name in", values, "itroleName");
            return (Criteria) this;
        }

        public Criteria andItroleNameNotIn(List<String> values) {
            addCriterion("itrole_name not in", values, "itroleName");
            return (Criteria) this;
        }

        public Criteria andItroleNameBetween(String value1, String value2) {
            addCriterion("itrole_name between", value1, value2, "itroleName");
            return (Criteria) this;
        }

        public Criteria andItroleNameNotBetween(String value1, String value2) {
            addCriterion("itrole_name not between", value1, value2, "itroleName");
            return (Criteria) this;
        }

        public Criteria andItroleDescIsNull() {
            addCriterion("itrole_desc is null");
            return (Criteria) this;
        }

        public Criteria andItroleDescIsNotNull() {
            addCriterion("itrole_desc is not null");
            return (Criteria) this;
        }

        public Criteria andItroleDescEqualTo(String value) {
            addCriterion("itrole_desc =", value, "itroleDesc");
            return (Criteria) this;
        }

        public Criteria andItroleDescNotEqualTo(String value) {
            addCriterion("itrole_desc <>", value, "itroleDesc");
            return (Criteria) this;
        }

        public Criteria andItroleDescGreaterThan(String value) {
            addCriterion("itrole_desc >", value, "itroleDesc");
            return (Criteria) this;
        }

        public Criteria andItroleDescGreaterThanOrEqualTo(String value) {
            addCriterion("itrole_desc >=", value, "itroleDesc");
            return (Criteria) this;
        }

        public Criteria andItroleDescLessThan(String value) {
            addCriterion("itrole_desc <", value, "itroleDesc");
            return (Criteria) this;
        }

        public Criteria andItroleDescLessThanOrEqualTo(String value) {
            addCriterion("itrole_desc <=", value, "itroleDesc");
            return (Criteria) this;
        }

        public Criteria andItroleDescLike(String value) {
            addCriterion("itrole_desc like", value, "itroleDesc");
            return (Criteria) this;
        }

        public Criteria andItroleDescNotLike(String value) {
            addCriterion("itrole_desc not like", value, "itroleDesc");
            return (Criteria) this;
        }

        public Criteria andItroleDescIn(List<String> values) {
            addCriterion("itrole_desc in", values, "itroleDesc");
            return (Criteria) this;
        }

        public Criteria andItroleDescNotIn(List<String> values) {
            addCriterion("itrole_desc not in", values, "itroleDesc");
            return (Criteria) this;
        }

        public Criteria andItroleDescBetween(String value1, String value2) {
            addCriterion("itrole_desc between", value1, value2, "itroleDesc");
            return (Criteria) this;
        }

        public Criteria andItroleDescNotBetween(String value1, String value2) {
            addCriterion("itrole_desc not between", value1, value2, "itroleDesc");
            return (Criteria) this;
        }

        public Criteria andItroleResUuidIsNull() {
            addCriterion("itrole_res_uuid is null");
            return (Criteria) this;
        }

        public Criteria andItroleResUuidIsNotNull() {
            addCriterion("itrole_res_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andItroleResUuidEqualTo(String value) {
            addCriterion("itrole_res_uuid =", value, "itroleResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleResUuidNotEqualTo(String value) {
            addCriterion("itrole_res_uuid <>", value, "itroleResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleResUuidGreaterThan(String value) {
            addCriterion("itrole_res_uuid >", value, "itroleResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleResUuidGreaterThanOrEqualTo(String value) {
            addCriterion("itrole_res_uuid >=", value, "itroleResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleResUuidLessThan(String value) {
            addCriterion("itrole_res_uuid <", value, "itroleResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleResUuidLessThanOrEqualTo(String value) {
            addCriterion("itrole_res_uuid <=", value, "itroleResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleResUuidLike(String value) {
            addCriterion("itrole_res_uuid like", value, "itroleResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleResUuidNotLike(String value) {
            addCriterion("itrole_res_uuid not like", value, "itroleResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleResUuidIn(List<String> values) {
            addCriterion("itrole_res_uuid in", values, "itroleResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleResUuidNotIn(List<String> values) {
            addCriterion("itrole_res_uuid not in", values, "itroleResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleResUuidBetween(String value1, String value2) {
            addCriterion("itrole_res_uuid between", value1, value2, "itroleResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleResUuidNotBetween(String value1, String value2) {
            addCriterion("itrole_res_uuid not between", value1, value2, "itroleResUuid");
            return (Criteria) this;
        }

        public Criteria andItroleTgtRoleUuidIsNull() {
            addCriterion("itrole_tgt_role_uuid is null");
            return (Criteria) this;
        }

        public Criteria andItroleTgtRoleUuidIsNotNull() {
            addCriterion("itrole_tgt_role_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andItroleTgtRoleUuidEqualTo(String value) {
            addCriterion("itrole_tgt_role_uuid =", value, "itroleTgtRoleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleTgtRoleUuidNotEqualTo(String value) {
            addCriterion("itrole_tgt_role_uuid <>", value, "itroleTgtRoleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleTgtRoleUuidGreaterThan(String value) {
            addCriterion("itrole_tgt_role_uuid >", value, "itroleTgtRoleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleTgtRoleUuidGreaterThanOrEqualTo(String value) {
            addCriterion("itrole_tgt_role_uuid >=", value, "itroleTgtRoleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleTgtRoleUuidLessThan(String value) {
            addCriterion("itrole_tgt_role_uuid <", value, "itroleTgtRoleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleTgtRoleUuidLessThanOrEqualTo(String value) {
            addCriterion("itrole_tgt_role_uuid <=", value, "itroleTgtRoleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleTgtRoleUuidLike(String value) {
            addCriterion("itrole_tgt_role_uuid like", value, "itroleTgtRoleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleTgtRoleUuidNotLike(String value) {
            addCriterion("itrole_tgt_role_uuid not like", value, "itroleTgtRoleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleTgtRoleUuidIn(List<String> values) {
            addCriterion("itrole_tgt_role_uuid in", values, "itroleTgtRoleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleTgtRoleUuidNotIn(List<String> values) {
            addCriterion("itrole_tgt_role_uuid not in", values, "itroleTgtRoleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleTgtRoleUuidBetween(String value1, String value2) {
            addCriterion("itrole_tgt_role_uuid between", value1, value2, "itroleTgtRoleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleTgtRoleUuidNotBetween(String value1, String value2) {
            addCriterion("itrole_tgt_role_uuid not between", value1, value2, "itroleTgtRoleUuid");
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