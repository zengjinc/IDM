package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class ResourceAttributeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourceAttributeExample() {
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

        public Criteria andResAttrResUuidIsNull() {
            addCriterion("res_attr_res_uuid is null");
            return (Criteria) this;
        }

        public Criteria andResAttrResUuidIsNotNull() {
            addCriterion("res_attr_res_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andResAttrResUuidEqualTo(String value) {
            addCriterion("res_attr_res_uuid =", value, "resAttrResUuid");
            return (Criteria) this;
        }

        public Criteria andResAttrResUuidNotEqualTo(String value) {
            addCriterion("res_attr_res_uuid <>", value, "resAttrResUuid");
            return (Criteria) this;
        }

        public Criteria andResAttrResUuidGreaterThan(String value) {
            addCriterion("res_attr_res_uuid >", value, "resAttrResUuid");
            return (Criteria) this;
        }

        public Criteria andResAttrResUuidGreaterThanOrEqualTo(String value) {
            addCriterion("res_attr_res_uuid >=", value, "resAttrResUuid");
            return (Criteria) this;
        }

        public Criteria andResAttrResUuidLessThan(String value) {
            addCriterion("res_attr_res_uuid <", value, "resAttrResUuid");
            return (Criteria) this;
        }

        public Criteria andResAttrResUuidLessThanOrEqualTo(String value) {
            addCriterion("res_attr_res_uuid <=", value, "resAttrResUuid");
            return (Criteria) this;
        }

        public Criteria andResAttrResUuidLike(String value) {
            addCriterion("res_attr_res_uuid like", value, "resAttrResUuid");
            return (Criteria) this;
        }

        public Criteria andResAttrResUuidNotLike(String value) {
            addCriterion("res_attr_res_uuid not like", value, "resAttrResUuid");
            return (Criteria) this;
        }

        public Criteria andResAttrResUuidIn(List<String> values) {
            addCriterion("res_attr_res_uuid in", values, "resAttrResUuid");
            return (Criteria) this;
        }

        public Criteria andResAttrResUuidNotIn(List<String> values) {
            addCriterion("res_attr_res_uuid not in", values, "resAttrResUuid");
            return (Criteria) this;
        }

        public Criteria andResAttrResUuidBetween(String value1, String value2) {
            addCriterion("res_attr_res_uuid between", value1, value2, "resAttrResUuid");
            return (Criteria) this;
        }

        public Criteria andResAttrResUuidNotBetween(String value1, String value2) {
            addCriterion("res_attr_res_uuid not between", value1, value2, "resAttrResUuid");
            return (Criteria) this;
        }

        public Criteria andResAttrNameIsNull() {
            addCriterion("res_attr_name is null");
            return (Criteria) this;
        }

        public Criteria andResAttrNameIsNotNull() {
            addCriterion("res_attr_name is not null");
            return (Criteria) this;
        }

        public Criteria andResAttrNameEqualTo(String value) {
            addCriterion("res_attr_name =", value, "resAttrName");
            return (Criteria) this;
        }

        public Criteria andResAttrNameNotEqualTo(String value) {
            addCriterion("res_attr_name <>", value, "resAttrName");
            return (Criteria) this;
        }

        public Criteria andResAttrNameGreaterThan(String value) {
            addCriterion("res_attr_name >", value, "resAttrName");
            return (Criteria) this;
        }

        public Criteria andResAttrNameGreaterThanOrEqualTo(String value) {
            addCriterion("res_attr_name >=", value, "resAttrName");
            return (Criteria) this;
        }

        public Criteria andResAttrNameLessThan(String value) {
            addCriterion("res_attr_name <", value, "resAttrName");
            return (Criteria) this;
        }

        public Criteria andResAttrNameLessThanOrEqualTo(String value) {
            addCriterion("res_attr_name <=", value, "resAttrName");
            return (Criteria) this;
        }

        public Criteria andResAttrNameLike(String value) {
            addCriterion("res_attr_name like", value, "resAttrName");
            return (Criteria) this;
        }

        public Criteria andResAttrNameNotLike(String value) {
            addCriterion("res_attr_name not like", value, "resAttrName");
            return (Criteria) this;
        }

        public Criteria andResAttrNameIn(List<String> values) {
            addCriterion("res_attr_name in", values, "resAttrName");
            return (Criteria) this;
        }

        public Criteria andResAttrNameNotIn(List<String> values) {
            addCriterion("res_attr_name not in", values, "resAttrName");
            return (Criteria) this;
        }

        public Criteria andResAttrNameBetween(String value1, String value2) {
            addCriterion("res_attr_name between", value1, value2, "resAttrName");
            return (Criteria) this;
        }

        public Criteria andResAttrNameNotBetween(String value1, String value2) {
            addCriterion("res_attr_name not between", value1, value2, "resAttrName");
            return (Criteria) this;
        }

        public Criteria andResAttrDatatypeIsNull() {
            addCriterion("res_attr_datatype is null");
            return (Criteria) this;
        }

        public Criteria andResAttrDatatypeIsNotNull() {
            addCriterion("res_attr_datatype is not null");
            return (Criteria) this;
        }

        public Criteria andResAttrDatatypeEqualTo(String value) {
            addCriterion("res_attr_datatype =", value, "resAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andResAttrDatatypeNotEqualTo(String value) {
            addCriterion("res_attr_datatype <>", value, "resAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andResAttrDatatypeGreaterThan(String value) {
            addCriterion("res_attr_datatype >", value, "resAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andResAttrDatatypeGreaterThanOrEqualTo(String value) {
            addCriterion("res_attr_datatype >=", value, "resAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andResAttrDatatypeLessThan(String value) {
            addCriterion("res_attr_datatype <", value, "resAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andResAttrDatatypeLessThanOrEqualTo(String value) {
            addCriterion("res_attr_datatype <=", value, "resAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andResAttrDatatypeLike(String value) {
            addCriterion("res_attr_datatype like", value, "resAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andResAttrDatatypeNotLike(String value) {
            addCriterion("res_attr_datatype not like", value, "resAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andResAttrDatatypeIn(List<String> values) {
            addCriterion("res_attr_datatype in", values, "resAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andResAttrDatatypeNotIn(List<String> values) {
            addCriterion("res_attr_datatype not in", values, "resAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andResAttrDatatypeBetween(String value1, String value2) {
            addCriterion("res_attr_datatype between", value1, value2, "resAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andResAttrDatatypeNotBetween(String value1, String value2) {
            addCriterion("res_attr_datatype not between", value1, value2, "resAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andResAttrValueIsNull() {
            addCriterion("res_attr_value is null");
            return (Criteria) this;
        }

        public Criteria andResAttrValueIsNotNull() {
            addCriterion("res_attr_value is not null");
            return (Criteria) this;
        }

        public Criteria andResAttrValueEqualTo(String value) {
            addCriterion("res_attr_value =", value, "resAttrValue");
            return (Criteria) this;
        }

        public Criteria andResAttrValueNotEqualTo(String value) {
            addCriterion("res_attr_value <>", value, "resAttrValue");
            return (Criteria) this;
        }

        public Criteria andResAttrValueGreaterThan(String value) {
            addCriterion("res_attr_value >", value, "resAttrValue");
            return (Criteria) this;
        }

        public Criteria andResAttrValueGreaterThanOrEqualTo(String value) {
            addCriterion("res_attr_value >=", value, "resAttrValue");
            return (Criteria) this;
        }

        public Criteria andResAttrValueLessThan(String value) {
            addCriterion("res_attr_value <", value, "resAttrValue");
            return (Criteria) this;
        }

        public Criteria andResAttrValueLessThanOrEqualTo(String value) {
            addCriterion("res_attr_value <=", value, "resAttrValue");
            return (Criteria) this;
        }

        public Criteria andResAttrValueLike(String value) {
            addCriterion("res_attr_value like", value, "resAttrValue");
            return (Criteria) this;
        }

        public Criteria andResAttrValueNotLike(String value) {
            addCriterion("res_attr_value not like", value, "resAttrValue");
            return (Criteria) this;
        }

        public Criteria andResAttrValueIn(List<String> values) {
            addCriterion("res_attr_value in", values, "resAttrValue");
            return (Criteria) this;
        }

        public Criteria andResAttrValueNotIn(List<String> values) {
            addCriterion("res_attr_value not in", values, "resAttrValue");
            return (Criteria) this;
        }

        public Criteria andResAttrValueBetween(String value1, String value2) {
            addCriterion("res_attr_value between", value1, value2, "resAttrValue");
            return (Criteria) this;
        }

        public Criteria andResAttrValueNotBetween(String value1, String value2) {
            addCriterion("res_attr_value not between", value1, value2, "resAttrValue");
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