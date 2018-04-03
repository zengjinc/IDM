package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserAttributeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserAttributeExample() {
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

        public Criteria andUserAttrUuidIsNull() {
            addCriterion("user_attr_uuid is null");
            return (Criteria) this;
        }

        public Criteria andUserAttrUuidIsNotNull() {
            addCriterion("user_attr_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUserAttrUuidEqualTo(String value) {
            addCriterion("user_attr_uuid =", value, "userAttrUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrUuidNotEqualTo(String value) {
            addCriterion("user_attr_uuid <>", value, "userAttrUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrUuidGreaterThan(String value) {
            addCriterion("user_attr_uuid >", value, "userAttrUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrUuidGreaterThanOrEqualTo(String value) {
            addCriterion("user_attr_uuid >=", value, "userAttrUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrUuidLessThan(String value) {
            addCriterion("user_attr_uuid <", value, "userAttrUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrUuidLessThanOrEqualTo(String value) {
            addCriterion("user_attr_uuid <=", value, "userAttrUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrUuidLike(String value) {
            addCriterion("user_attr_uuid like", value, "userAttrUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrUuidNotLike(String value) {
            addCriterion("user_attr_uuid not like", value, "userAttrUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrUuidIn(List<String> values) {
            addCriterion("user_attr_uuid in", values, "userAttrUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrUuidNotIn(List<String> values) {
            addCriterion("user_attr_uuid not in", values, "userAttrUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrUuidBetween(String value1, String value2) {
            addCriterion("user_attr_uuid between", value1, value2, "userAttrUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrUuidNotBetween(String value1, String value2) {
            addCriterion("user_attr_uuid not between", value1, value2, "userAttrUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidIsNull() {
            addCriterion("user_uuid is null");
            return (Criteria) this;
        }

        public Criteria andUserUuidIsNotNull() {
            addCriterion("user_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUserUuidEqualTo(String value) {
            addCriterion("user_uuid =", value, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidNotEqualTo(String value) {
            addCriterion("user_uuid <>", value, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidGreaterThan(String value) {
            addCriterion("user_uuid >", value, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidGreaterThanOrEqualTo(String value) {
            addCriterion("user_uuid >=", value, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidLessThan(String value) {
            addCriterion("user_uuid <", value, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidLessThanOrEqualTo(String value) {
            addCriterion("user_uuid <=", value, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidLike(String value) {
            addCriterion("user_uuid like", value, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidNotLike(String value) {
            addCriterion("user_uuid not like", value, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidIn(List<String> values) {
            addCriterion("user_uuid in", values, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidNotIn(List<String> values) {
            addCriterion("user_uuid not in", values, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidBetween(String value1, String value2) {
            addCriterion("user_uuid between", value1, value2, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidNotBetween(String value1, String value2) {
            addCriterion("user_uuid not between", value1, value2, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefUuidIsNull() {
            addCriterion("user_attr_def_uuid is null");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefUuidIsNotNull() {
            addCriterion("user_attr_def_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefUuidEqualTo(String value) {
            addCriterion("user_attr_def_uuid =", value, "userAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefUuidNotEqualTo(String value) {
            addCriterion("user_attr_def_uuid <>", value, "userAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefUuidGreaterThan(String value) {
            addCriterion("user_attr_def_uuid >", value, "userAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefUuidGreaterThanOrEqualTo(String value) {
            addCriterion("user_attr_def_uuid >=", value, "userAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefUuidLessThan(String value) {
            addCriterion("user_attr_def_uuid <", value, "userAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefUuidLessThanOrEqualTo(String value) {
            addCriterion("user_attr_def_uuid <=", value, "userAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefUuidLike(String value) {
            addCriterion("user_attr_def_uuid like", value, "userAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefUuidNotLike(String value) {
            addCriterion("user_attr_def_uuid not like", value, "userAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefUuidIn(List<String> values) {
            addCriterion("user_attr_def_uuid in", values, "userAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefUuidNotIn(List<String> values) {
            addCriterion("user_attr_def_uuid not in", values, "userAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefUuidBetween(String value1, String value2) {
            addCriterion("user_attr_def_uuid between", value1, value2, "userAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefUuidNotBetween(String value1, String value2) {
            addCriterion("user_attr_def_uuid not between", value1, value2, "userAttrDefUuid");
            return (Criteria) this;
        }

        public Criteria andUserAttriValueIsNull() {
            addCriterion("user_attri_value is null");
            return (Criteria) this;
        }

        public Criteria andUserAttriValueIsNotNull() {
            addCriterion("user_attri_value is not null");
            return (Criteria) this;
        }

        public Criteria andUserAttriValueEqualTo(String value) {
            addCriterion("user_attri_value =", value, "userAttriValue");
            return (Criteria) this;
        }

        public Criteria andUserAttriValueNotEqualTo(String value) {
            addCriterion("user_attri_value <>", value, "userAttriValue");
            return (Criteria) this;
        }

        public Criteria andUserAttriValueGreaterThan(String value) {
            addCriterion("user_attri_value >", value, "userAttriValue");
            return (Criteria) this;
        }

        public Criteria andUserAttriValueGreaterThanOrEqualTo(String value) {
            addCriterion("user_attri_value >=", value, "userAttriValue");
            return (Criteria) this;
        }

        public Criteria andUserAttriValueLessThan(String value) {
            addCriterion("user_attri_value <", value, "userAttriValue");
            return (Criteria) this;
        }

        public Criteria andUserAttriValueLessThanOrEqualTo(String value) {
            addCriterion("user_attri_value <=", value, "userAttriValue");
            return (Criteria) this;
        }

        public Criteria andUserAttriValueLike(String value) {
            addCriterion("user_attri_value like", value, "userAttriValue");
            return (Criteria) this;
        }

        public Criteria andUserAttriValueNotLike(String value) {
            addCriterion("user_attri_value not like", value, "userAttriValue");
            return (Criteria) this;
        }

        public Criteria andUserAttriValueIn(List<String> values) {
            addCriterion("user_attri_value in", values, "userAttriValue");
            return (Criteria) this;
        }

        public Criteria andUserAttriValueNotIn(List<String> values) {
            addCriterion("user_attri_value not in", values, "userAttriValue");
            return (Criteria) this;
        }

        public Criteria andUserAttriValueBetween(String value1, String value2) {
            addCriterion("user_attri_value between", value1, value2, "userAttriValue");
            return (Criteria) this;
        }

        public Criteria andUserAttriValueNotBetween(String value1, String value2) {
            addCriterion("user_attri_value not between", value1, value2, "userAttriValue");
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