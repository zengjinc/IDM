package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserAttrDefExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserAttrDefExample() {
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

        public Criteria andUserAttrDefKeyIsNull() {
            addCriterion("user_attr_def_key is null");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefKeyIsNotNull() {
            addCriterion("user_attr_def_key is not null");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefKeyEqualTo(String value) {
            addCriterion("user_attr_def_key =", value, "userAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefKeyNotEqualTo(String value) {
            addCriterion("user_attr_def_key <>", value, "userAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefKeyGreaterThan(String value) {
            addCriterion("user_attr_def_key >", value, "userAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefKeyGreaterThanOrEqualTo(String value) {
            addCriterion("user_attr_def_key >=", value, "userAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefKeyLessThan(String value) {
            addCriterion("user_attr_def_key <", value, "userAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefKeyLessThanOrEqualTo(String value) {
            addCriterion("user_attr_def_key <=", value, "userAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefKeyLike(String value) {
            addCriterion("user_attr_def_key like", value, "userAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefKeyNotLike(String value) {
            addCriterion("user_attr_def_key not like", value, "userAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefKeyIn(List<String> values) {
            addCriterion("user_attr_def_key in", values, "userAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefKeyNotIn(List<String> values) {
            addCriterion("user_attr_def_key not in", values, "userAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefKeyBetween(String value1, String value2) {
            addCriterion("user_attr_def_key between", value1, value2, "userAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefKeyNotBetween(String value1, String value2) {
            addCriterion("user_attr_def_key not between", value1, value2, "userAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefDatatypeIsNull() {
            addCriterion("user_attr_def_datatype is null");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefDatatypeIsNotNull() {
            addCriterion("user_attr_def_datatype is not null");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefDatatypeEqualTo(String value) {
            addCriterion("user_attr_def_datatype =", value, "userAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefDatatypeNotEqualTo(String value) {
            addCriterion("user_attr_def_datatype <>", value, "userAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefDatatypeGreaterThan(String value) {
            addCriterion("user_attr_def_datatype >", value, "userAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefDatatypeGreaterThanOrEqualTo(String value) {
            addCriterion("user_attr_def_datatype >=", value, "userAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefDatatypeLessThan(String value) {
            addCriterion("user_attr_def_datatype <", value, "userAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefDatatypeLessThanOrEqualTo(String value) {
            addCriterion("user_attr_def_datatype <=", value, "userAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefDatatypeLike(String value) {
            addCriterion("user_attr_def_datatype like", value, "userAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefDatatypeNotLike(String value) {
            addCriterion("user_attr_def_datatype not like", value, "userAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefDatatypeIn(List<String> values) {
            addCriterion("user_attr_def_datatype in", values, "userAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefDatatypeNotIn(List<String> values) {
            addCriterion("user_attr_def_datatype not in", values, "userAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefDatatypeBetween(String value1, String value2) {
            addCriterion("user_attr_def_datatype between", value1, value2, "userAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefDatatypeNotBetween(String value1, String value2) {
            addCriterion("user_attr_def_datatype not between", value1, value2, "userAttrDefDatatype");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefStatusIsNull() {
            addCriterion("user_attr_def_status is null");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefStatusIsNotNull() {
            addCriterion("user_attr_def_status is not null");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefStatusEqualTo(Integer value) {
            addCriterion("user_attr_def_status =", value, "userAttrDefStatus");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefStatusNotEqualTo(Integer value) {
            addCriterion("user_attr_def_status <>", value, "userAttrDefStatus");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefStatusGreaterThan(Integer value) {
            addCriterion("user_attr_def_status >", value, "userAttrDefStatus");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_attr_def_status >=", value, "userAttrDefStatus");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefStatusLessThan(Integer value) {
            addCriterion("user_attr_def_status <", value, "userAttrDefStatus");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefStatusLessThanOrEqualTo(Integer value) {
            addCriterion("user_attr_def_status <=", value, "userAttrDefStatus");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefStatusIn(List<Integer> values) {
            addCriterion("user_attr_def_status in", values, "userAttrDefStatus");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefStatusNotIn(List<Integer> values) {
            addCriterion("user_attr_def_status not in", values, "userAttrDefStatus");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefStatusBetween(Integer value1, Integer value2) {
            addCriterion("user_attr_def_status between", value1, value2, "userAttrDefStatus");
            return (Criteria) this;
        }

        public Criteria andUserAttrDefStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("user_attr_def_status not between", value1, value2, "userAttrDefStatus");
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