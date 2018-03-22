package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class AccessControlScopeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccessControlScopeExample() {
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

        public Criteria andScpCodeIsNull() {
            addCriterion("scp_code is null");
            return (Criteria) this;
        }

        public Criteria andScpCodeIsNotNull() {
            addCriterion("scp_code is not null");
            return (Criteria) this;
        }

        public Criteria andScpCodeEqualTo(Integer value) {
            addCriterion("scp_code =", value, "scpCode");
            return (Criteria) this;
        }

        public Criteria andScpCodeNotEqualTo(Integer value) {
            addCriterion("scp_code <>", value, "scpCode");
            return (Criteria) this;
        }

        public Criteria andScpCodeGreaterThan(Integer value) {
            addCriterion("scp_code >", value, "scpCode");
            return (Criteria) this;
        }

        public Criteria andScpCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("scp_code >=", value, "scpCode");
            return (Criteria) this;
        }

        public Criteria andScpCodeLessThan(Integer value) {
            addCriterion("scp_code <", value, "scpCode");
            return (Criteria) this;
        }

        public Criteria andScpCodeLessThanOrEqualTo(Integer value) {
            addCriterion("scp_code <=", value, "scpCode");
            return (Criteria) this;
        }

        public Criteria andScpCodeIn(List<Integer> values) {
            addCriterion("scp_code in", values, "scpCode");
            return (Criteria) this;
        }

        public Criteria andScpCodeNotIn(List<Integer> values) {
            addCriterion("scp_code not in", values, "scpCode");
            return (Criteria) this;
        }

        public Criteria andScpCodeBetween(Integer value1, Integer value2) {
            addCriterion("scp_code between", value1, value2, "scpCode");
            return (Criteria) this;
        }

        public Criteria andScpCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("scp_code not between", value1, value2, "scpCode");
            return (Criteria) this;
        }

        public Criteria andScpNameIsNull() {
            addCriterion("scp_name is null");
            return (Criteria) this;
        }

        public Criteria andScpNameIsNotNull() {
            addCriterion("scp_name is not null");
            return (Criteria) this;
        }

        public Criteria andScpNameEqualTo(String value) {
            addCriterion("scp_name =", value, "scpName");
            return (Criteria) this;
        }

        public Criteria andScpNameNotEqualTo(String value) {
            addCriterion("scp_name <>", value, "scpName");
            return (Criteria) this;
        }

        public Criteria andScpNameGreaterThan(String value) {
            addCriterion("scp_name >", value, "scpName");
            return (Criteria) this;
        }

        public Criteria andScpNameGreaterThanOrEqualTo(String value) {
            addCriterion("scp_name >=", value, "scpName");
            return (Criteria) this;
        }

        public Criteria andScpNameLessThan(String value) {
            addCriterion("scp_name <", value, "scpName");
            return (Criteria) this;
        }

        public Criteria andScpNameLessThanOrEqualTo(String value) {
            addCriterion("scp_name <=", value, "scpName");
            return (Criteria) this;
        }

        public Criteria andScpNameLike(String value) {
            addCriterion("scp_name like", value, "scpName");
            return (Criteria) this;
        }

        public Criteria andScpNameNotLike(String value) {
            addCriterion("scp_name not like", value, "scpName");
            return (Criteria) this;
        }

        public Criteria andScpNameIn(List<String> values) {
            addCriterion("scp_name in", values, "scpName");
            return (Criteria) this;
        }

        public Criteria andScpNameNotIn(List<String> values) {
            addCriterion("scp_name not in", values, "scpName");
            return (Criteria) this;
        }

        public Criteria andScpNameBetween(String value1, String value2) {
            addCriterion("scp_name between", value1, value2, "scpName");
            return (Criteria) this;
        }

        public Criteria andScpNameNotBetween(String value1, String value2) {
            addCriterion("scp_name not between", value1, value2, "scpName");
            return (Criteria) this;
        }

        public Criteria andScpDescIsNull() {
            addCriterion("scp_desc is null");
            return (Criteria) this;
        }

        public Criteria andScpDescIsNotNull() {
            addCriterion("scp_desc is not null");
            return (Criteria) this;
        }

        public Criteria andScpDescEqualTo(String value) {
            addCriterion("scp_desc =", value, "scpDesc");
            return (Criteria) this;
        }

        public Criteria andScpDescNotEqualTo(String value) {
            addCriterion("scp_desc <>", value, "scpDesc");
            return (Criteria) this;
        }

        public Criteria andScpDescGreaterThan(String value) {
            addCriterion("scp_desc >", value, "scpDesc");
            return (Criteria) this;
        }

        public Criteria andScpDescGreaterThanOrEqualTo(String value) {
            addCriterion("scp_desc >=", value, "scpDesc");
            return (Criteria) this;
        }

        public Criteria andScpDescLessThan(String value) {
            addCriterion("scp_desc <", value, "scpDesc");
            return (Criteria) this;
        }

        public Criteria andScpDescLessThanOrEqualTo(String value) {
            addCriterion("scp_desc <=", value, "scpDesc");
            return (Criteria) this;
        }

        public Criteria andScpDescLike(String value) {
            addCriterion("scp_desc like", value, "scpDesc");
            return (Criteria) this;
        }

        public Criteria andScpDescNotLike(String value) {
            addCriterion("scp_desc not like", value, "scpDesc");
            return (Criteria) this;
        }

        public Criteria andScpDescIn(List<String> values) {
            addCriterion("scp_desc in", values, "scpDesc");
            return (Criteria) this;
        }

        public Criteria andScpDescNotIn(List<String> values) {
            addCriterion("scp_desc not in", values, "scpDesc");
            return (Criteria) this;
        }

        public Criteria andScpDescBetween(String value1, String value2) {
            addCriterion("scp_desc between", value1, value2, "scpDesc");
            return (Criteria) this;
        }

        public Criteria andScpDescNotBetween(String value1, String value2) {
            addCriterion("scp_desc not between", value1, value2, "scpDesc");
            return (Criteria) this;
        }

        public Criteria andScpHandlerIsNull() {
            addCriterion("scp_handler is null");
            return (Criteria) this;
        }

        public Criteria andScpHandlerIsNotNull() {
            addCriterion("scp_handler is not null");
            return (Criteria) this;
        }

        public Criteria andScpHandlerEqualTo(String value) {
            addCriterion("scp_handler =", value, "scpHandler");
            return (Criteria) this;
        }

        public Criteria andScpHandlerNotEqualTo(String value) {
            addCriterion("scp_handler <>", value, "scpHandler");
            return (Criteria) this;
        }

        public Criteria andScpHandlerGreaterThan(String value) {
            addCriterion("scp_handler >", value, "scpHandler");
            return (Criteria) this;
        }

        public Criteria andScpHandlerGreaterThanOrEqualTo(String value) {
            addCriterion("scp_handler >=", value, "scpHandler");
            return (Criteria) this;
        }

        public Criteria andScpHandlerLessThan(String value) {
            addCriterion("scp_handler <", value, "scpHandler");
            return (Criteria) this;
        }

        public Criteria andScpHandlerLessThanOrEqualTo(String value) {
            addCriterion("scp_handler <=", value, "scpHandler");
            return (Criteria) this;
        }

        public Criteria andScpHandlerLike(String value) {
            addCriterion("scp_handler like", value, "scpHandler");
            return (Criteria) this;
        }

        public Criteria andScpHandlerNotLike(String value) {
            addCriterion("scp_handler not like", value, "scpHandler");
            return (Criteria) this;
        }

        public Criteria andScpHandlerIn(List<String> values) {
            addCriterion("scp_handler in", values, "scpHandler");
            return (Criteria) this;
        }

        public Criteria andScpHandlerNotIn(List<String> values) {
            addCriterion("scp_handler not in", values, "scpHandler");
            return (Criteria) this;
        }

        public Criteria andScpHandlerBetween(String value1, String value2) {
            addCriterion("scp_handler between", value1, value2, "scpHandler");
            return (Criteria) this;
        }

        public Criteria andScpHandlerNotBetween(String value1, String value2) {
            addCriterion("scp_handler not between", value1, value2, "scpHandler");
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