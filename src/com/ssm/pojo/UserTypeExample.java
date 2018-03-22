package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserTypeExample() {
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

        public Criteria andUserTypeUuidIsNull() {
            addCriterion("user_type_uuid is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeUuidIsNotNull() {
            addCriterion("user_type_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeUuidEqualTo(String value) {
            addCriterion("user_type_uuid =", value, "userTypeUuid");
            return (Criteria) this;
        }

        public Criteria andUserTypeUuidNotEqualTo(String value) {
            addCriterion("user_type_uuid <>", value, "userTypeUuid");
            return (Criteria) this;
        }

        public Criteria andUserTypeUuidGreaterThan(String value) {
            addCriterion("user_type_uuid >", value, "userTypeUuid");
            return (Criteria) this;
        }

        public Criteria andUserTypeUuidGreaterThanOrEqualTo(String value) {
            addCriterion("user_type_uuid >=", value, "userTypeUuid");
            return (Criteria) this;
        }

        public Criteria andUserTypeUuidLessThan(String value) {
            addCriterion("user_type_uuid <", value, "userTypeUuid");
            return (Criteria) this;
        }

        public Criteria andUserTypeUuidLessThanOrEqualTo(String value) {
            addCriterion("user_type_uuid <=", value, "userTypeUuid");
            return (Criteria) this;
        }

        public Criteria andUserTypeUuidLike(String value) {
            addCriterion("user_type_uuid like", value, "userTypeUuid");
            return (Criteria) this;
        }

        public Criteria andUserTypeUuidNotLike(String value) {
            addCriterion("user_type_uuid not like", value, "userTypeUuid");
            return (Criteria) this;
        }

        public Criteria andUserTypeUuidIn(List<String> values) {
            addCriterion("user_type_uuid in", values, "userTypeUuid");
            return (Criteria) this;
        }

        public Criteria andUserTypeUuidNotIn(List<String> values) {
            addCriterion("user_type_uuid not in", values, "userTypeUuid");
            return (Criteria) this;
        }

        public Criteria andUserTypeUuidBetween(String value1, String value2) {
            addCriterion("user_type_uuid between", value1, value2, "userTypeUuid");
            return (Criteria) this;
        }

        public Criteria andUserTypeUuidNotBetween(String value1, String value2) {
            addCriterion("user_type_uuid not between", value1, value2, "userTypeUuid");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameIsNull() {
            addCriterion("user_type_name is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameIsNotNull() {
            addCriterion("user_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameEqualTo(String value) {
            addCriterion("user_type_name =", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameNotEqualTo(String value) {
            addCriterion("user_type_name <>", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameGreaterThan(String value) {
            addCriterion("user_type_name >", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_type_name >=", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameLessThan(String value) {
            addCriterion("user_type_name <", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameLessThanOrEqualTo(String value) {
            addCriterion("user_type_name <=", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameLike(String value) {
            addCriterion("user_type_name like", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameNotLike(String value) {
            addCriterion("user_type_name not like", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameIn(List<String> values) {
            addCriterion("user_type_name in", values, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameNotIn(List<String> values) {
            addCriterion("user_type_name not in", values, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameBetween(String value1, String value2) {
            addCriterion("user_type_name between", value1, value2, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameNotBetween(String value1, String value2) {
            addCriterion("user_type_name not between", value1, value2, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeDescIsNull() {
            addCriterion("user_type_desc is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeDescIsNotNull() {
            addCriterion("user_type_desc is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeDescEqualTo(String value) {
            addCriterion("user_type_desc =", value, "userTypeDesc");
            return (Criteria) this;
        }

        public Criteria andUserTypeDescNotEqualTo(String value) {
            addCriterion("user_type_desc <>", value, "userTypeDesc");
            return (Criteria) this;
        }

        public Criteria andUserTypeDescGreaterThan(String value) {
            addCriterion("user_type_desc >", value, "userTypeDesc");
            return (Criteria) this;
        }

        public Criteria andUserTypeDescGreaterThanOrEqualTo(String value) {
            addCriterion("user_type_desc >=", value, "userTypeDesc");
            return (Criteria) this;
        }

        public Criteria andUserTypeDescLessThan(String value) {
            addCriterion("user_type_desc <", value, "userTypeDesc");
            return (Criteria) this;
        }

        public Criteria andUserTypeDescLessThanOrEqualTo(String value) {
            addCriterion("user_type_desc <=", value, "userTypeDesc");
            return (Criteria) this;
        }

        public Criteria andUserTypeDescLike(String value) {
            addCriterion("user_type_desc like", value, "userTypeDesc");
            return (Criteria) this;
        }

        public Criteria andUserTypeDescNotLike(String value) {
            addCriterion("user_type_desc not like", value, "userTypeDesc");
            return (Criteria) this;
        }

        public Criteria andUserTypeDescIn(List<String> values) {
            addCriterion("user_type_desc in", values, "userTypeDesc");
            return (Criteria) this;
        }

        public Criteria andUserTypeDescNotIn(List<String> values) {
            addCriterion("user_type_desc not in", values, "userTypeDesc");
            return (Criteria) this;
        }

        public Criteria andUserTypeDescBetween(String value1, String value2) {
            addCriterion("user_type_desc between", value1, value2, "userTypeDesc");
            return (Criteria) this;
        }

        public Criteria andUserTypeDescNotBetween(String value1, String value2) {
            addCriterion("user_type_desc not between", value1, value2, "userTypeDesc");
            return (Criteria) this;
        }

        public Criteria andUserTypeStatusIsNull() {
            addCriterion("user_type_status is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeStatusIsNotNull() {
            addCriterion("user_type_status is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeStatusEqualTo(Integer value) {
            addCriterion("user_type_status =", value, "userTypeStatus");
            return (Criteria) this;
        }

        public Criteria andUserTypeStatusNotEqualTo(Integer value) {
            addCriterion("user_type_status <>", value, "userTypeStatus");
            return (Criteria) this;
        }

        public Criteria andUserTypeStatusGreaterThan(Integer value) {
            addCriterion("user_type_status >", value, "userTypeStatus");
            return (Criteria) this;
        }

        public Criteria andUserTypeStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_type_status >=", value, "userTypeStatus");
            return (Criteria) this;
        }

        public Criteria andUserTypeStatusLessThan(Integer value) {
            addCriterion("user_type_status <", value, "userTypeStatus");
            return (Criteria) this;
        }

        public Criteria andUserTypeStatusLessThanOrEqualTo(Integer value) {
            addCriterion("user_type_status <=", value, "userTypeStatus");
            return (Criteria) this;
        }

        public Criteria andUserTypeStatusIn(List<Integer> values) {
            addCriterion("user_type_status in", values, "userTypeStatus");
            return (Criteria) this;
        }

        public Criteria andUserTypeStatusNotIn(List<Integer> values) {
            addCriterion("user_type_status not in", values, "userTypeStatus");
            return (Criteria) this;
        }

        public Criteria andUserTypeStatusBetween(Integer value1, Integer value2) {
            addCriterion("user_type_status between", value1, value2, "userTypeStatus");
            return (Criteria) this;
        }

        public Criteria andUserTypeStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("user_type_status not between", value1, value2, "userTypeStatus");
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