package com.ssm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountExample() {
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

        public Criteria andAcctUuidIsNull() {
            addCriterion("acct_uuid is null");
            return (Criteria) this;
        }

        public Criteria andAcctUuidIsNotNull() {
            addCriterion("acct_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andAcctUuidEqualTo(String value) {
            addCriterion("acct_uuid =", value, "acctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctUuidNotEqualTo(String value) {
            addCriterion("acct_uuid <>", value, "acctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctUuidGreaterThan(String value) {
            addCriterion("acct_uuid >", value, "acctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctUuidGreaterThanOrEqualTo(String value) {
            addCriterion("acct_uuid >=", value, "acctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctUuidLessThan(String value) {
            addCriterion("acct_uuid <", value, "acctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctUuidLessThanOrEqualTo(String value) {
            addCriterion("acct_uuid <=", value, "acctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctUuidLike(String value) {
            addCriterion("acct_uuid like", value, "acctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctUuidNotLike(String value) {
            addCriterion("acct_uuid not like", value, "acctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctUuidIn(List<String> values) {
            addCriterion("acct_uuid in", values, "acctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctUuidNotIn(List<String> values) {
            addCriterion("acct_uuid not in", values, "acctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctUuidBetween(String value1, String value2) {
            addCriterion("acct_uuid between", value1, value2, "acctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctUuidNotBetween(String value1, String value2) {
            addCriterion("acct_uuid not between", value1, value2, "acctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctLoginIdIsNull() {
            addCriterion("acct_login_id is null");
            return (Criteria) this;
        }

        public Criteria andAcctLoginIdIsNotNull() {
            addCriterion("acct_login_id is not null");
            return (Criteria) this;
        }

        public Criteria andAcctLoginIdEqualTo(String value) {
            addCriterion("acct_login_id =", value, "acctLoginId");
            return (Criteria) this;
        }

        public Criteria andAcctLoginIdNotEqualTo(String value) {
            addCriterion("acct_login_id <>", value, "acctLoginId");
            return (Criteria) this;
        }

        public Criteria andAcctLoginIdGreaterThan(String value) {
            addCriterion("acct_login_id >", value, "acctLoginId");
            return (Criteria) this;
        }

        public Criteria andAcctLoginIdGreaterThanOrEqualTo(String value) {
            addCriterion("acct_login_id >=", value, "acctLoginId");
            return (Criteria) this;
        }

        public Criteria andAcctLoginIdLessThan(String value) {
            addCriterion("acct_login_id <", value, "acctLoginId");
            return (Criteria) this;
        }

        public Criteria andAcctLoginIdLessThanOrEqualTo(String value) {
            addCriterion("acct_login_id <=", value, "acctLoginId");
            return (Criteria) this;
        }

        public Criteria andAcctLoginIdLike(String value) {
            addCriterion("acct_login_id like", value, "acctLoginId");
            return (Criteria) this;
        }

        public Criteria andAcctLoginIdNotLike(String value) {
            addCriterion("acct_login_id not like", value, "acctLoginId");
            return (Criteria) this;
        }

        public Criteria andAcctLoginIdIn(List<String> values) {
            addCriterion("acct_login_id in", values, "acctLoginId");
            return (Criteria) this;
        }

        public Criteria andAcctLoginIdNotIn(List<String> values) {
            addCriterion("acct_login_id not in", values, "acctLoginId");
            return (Criteria) this;
        }

        public Criteria andAcctLoginIdBetween(String value1, String value2) {
            addCriterion("acct_login_id between", value1, value2, "acctLoginId");
            return (Criteria) this;
        }

        public Criteria andAcctLoginIdNotBetween(String value1, String value2) {
            addCriterion("acct_login_id not between", value1, value2, "acctLoginId");
            return (Criteria) this;
        }

        public Criteria andAcctResUuidIsNull() {
            addCriterion("acct_res_uuid is null");
            return (Criteria) this;
        }

        public Criteria andAcctResUuidIsNotNull() {
            addCriterion("acct_res_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andAcctResUuidEqualTo(String value) {
            addCriterion("acct_res_uuid =", value, "acctResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctResUuidNotEqualTo(String value) {
            addCriterion("acct_res_uuid <>", value, "acctResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctResUuidGreaterThan(String value) {
            addCriterion("acct_res_uuid >", value, "acctResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctResUuidGreaterThanOrEqualTo(String value) {
            addCriterion("acct_res_uuid >=", value, "acctResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctResUuidLessThan(String value) {
            addCriterion("acct_res_uuid <", value, "acctResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctResUuidLessThanOrEqualTo(String value) {
            addCriterion("acct_res_uuid <=", value, "acctResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctResUuidLike(String value) {
            addCriterion("acct_res_uuid like", value, "acctResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctResUuidNotLike(String value) {
            addCriterion("acct_res_uuid not like", value, "acctResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctResUuidIn(List<String> values) {
            addCriterion("acct_res_uuid in", values, "acctResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctResUuidNotIn(List<String> values) {
            addCriterion("acct_res_uuid not in", values, "acctResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctResUuidBetween(String value1, String value2) {
            addCriterion("acct_res_uuid between", value1, value2, "acctResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctResUuidNotBetween(String value1, String value2) {
            addCriterion("acct_res_uuid not between", value1, value2, "acctResUuid");
            return (Criteria) this;
        }

        public Criteria andAcctTgtUuidIsNull() {
            addCriterion("acct_tgt_uuid is null");
            return (Criteria) this;
        }

        public Criteria andAcctTgtUuidIsNotNull() {
            addCriterion("acct_tgt_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andAcctTgtUuidEqualTo(String value) {
            addCriterion("acct_tgt_uuid =", value, "acctTgtUuid");
            return (Criteria) this;
        }

        public Criteria andAcctTgtUuidNotEqualTo(String value) {
            addCriterion("acct_tgt_uuid <>", value, "acctTgtUuid");
            return (Criteria) this;
        }

        public Criteria andAcctTgtUuidGreaterThan(String value) {
            addCriterion("acct_tgt_uuid >", value, "acctTgtUuid");
            return (Criteria) this;
        }

        public Criteria andAcctTgtUuidGreaterThanOrEqualTo(String value) {
            addCriterion("acct_tgt_uuid >=", value, "acctTgtUuid");
            return (Criteria) this;
        }

        public Criteria andAcctTgtUuidLessThan(String value) {
            addCriterion("acct_tgt_uuid <", value, "acctTgtUuid");
            return (Criteria) this;
        }

        public Criteria andAcctTgtUuidLessThanOrEqualTo(String value) {
            addCriterion("acct_tgt_uuid <=", value, "acctTgtUuid");
            return (Criteria) this;
        }

        public Criteria andAcctTgtUuidLike(String value) {
            addCriterion("acct_tgt_uuid like", value, "acctTgtUuid");
            return (Criteria) this;
        }

        public Criteria andAcctTgtUuidNotLike(String value) {
            addCriterion("acct_tgt_uuid not like", value, "acctTgtUuid");
            return (Criteria) this;
        }

        public Criteria andAcctTgtUuidIn(List<String> values) {
            addCriterion("acct_tgt_uuid in", values, "acctTgtUuid");
            return (Criteria) this;
        }

        public Criteria andAcctTgtUuidNotIn(List<String> values) {
            addCriterion("acct_tgt_uuid not in", values, "acctTgtUuid");
            return (Criteria) this;
        }

        public Criteria andAcctTgtUuidBetween(String value1, String value2) {
            addCriterion("acct_tgt_uuid between", value1, value2, "acctTgtUuid");
            return (Criteria) this;
        }

        public Criteria andAcctTgtUuidNotBetween(String value1, String value2) {
            addCriterion("acct_tgt_uuid not between", value1, value2, "acctTgtUuid");
            return (Criteria) this;
        }

        public Criteria andAcctPrimaryIsNull() {
            addCriterion("acct_primary is null");
            return (Criteria) this;
        }

        public Criteria andAcctPrimaryIsNotNull() {
            addCriterion("acct_primary is not null");
            return (Criteria) this;
        }

        public Criteria andAcctPrimaryEqualTo(Integer value) {
            addCriterion("acct_primary =", value, "acctPrimary");
            return (Criteria) this;
        }

        public Criteria andAcctPrimaryNotEqualTo(Integer value) {
            addCriterion("acct_primary <>", value, "acctPrimary");
            return (Criteria) this;
        }

        public Criteria andAcctPrimaryGreaterThan(Integer value) {
            addCriterion("acct_primary >", value, "acctPrimary");
            return (Criteria) this;
        }

        public Criteria andAcctPrimaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("acct_primary >=", value, "acctPrimary");
            return (Criteria) this;
        }

        public Criteria andAcctPrimaryLessThan(Integer value) {
            addCriterion("acct_primary <", value, "acctPrimary");
            return (Criteria) this;
        }

        public Criteria andAcctPrimaryLessThanOrEqualTo(Integer value) {
            addCriterion("acct_primary <=", value, "acctPrimary");
            return (Criteria) this;
        }

        public Criteria andAcctPrimaryIn(List<Integer> values) {
            addCriterion("acct_primary in", values, "acctPrimary");
            return (Criteria) this;
        }

        public Criteria andAcctPrimaryNotIn(List<Integer> values) {
            addCriterion("acct_primary not in", values, "acctPrimary");
            return (Criteria) this;
        }

        public Criteria andAcctPrimaryBetween(Integer value1, Integer value2) {
            addCriterion("acct_primary between", value1, value2, "acctPrimary");
            return (Criteria) this;
        }

        public Criteria andAcctPrimaryNotBetween(Integer value1, Integer value2) {
            addCriterion("acct_primary not between", value1, value2, "acctPrimary");
            return (Criteria) this;
        }

        public Criteria andAcctStatusIsNull() {
            addCriterion("acct_status is null");
            return (Criteria) this;
        }

        public Criteria andAcctStatusIsNotNull() {
            addCriterion("acct_status is not null");
            return (Criteria) this;
        }

        public Criteria andAcctStatusEqualTo(Integer value) {
            addCriterion("acct_status =", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusNotEqualTo(Integer value) {
            addCriterion("acct_status <>", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusGreaterThan(Integer value) {
            addCriterion("acct_status >", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("acct_status >=", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusLessThan(Integer value) {
            addCriterion("acct_status <", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusLessThanOrEqualTo(Integer value) {
            addCriterion("acct_status <=", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusIn(List<Integer> values) {
            addCriterion("acct_status in", values, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusNotIn(List<Integer> values) {
            addCriterion("acct_status not in", values, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusBetween(Integer value1, Integer value2) {
            addCriterion("acct_status between", value1, value2, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("acct_status not between", value1, value2, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctCreateorUuidIsNull() {
            addCriterion("acct_createor_uuid is null");
            return (Criteria) this;
        }

        public Criteria andAcctCreateorUuidIsNotNull() {
            addCriterion("acct_createor_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andAcctCreateorUuidEqualTo(String value) {
            addCriterion("acct_createor_uuid =", value, "acctCreateorUuid");
            return (Criteria) this;
        }

        public Criteria andAcctCreateorUuidNotEqualTo(String value) {
            addCriterion("acct_createor_uuid <>", value, "acctCreateorUuid");
            return (Criteria) this;
        }

        public Criteria andAcctCreateorUuidGreaterThan(String value) {
            addCriterion("acct_createor_uuid >", value, "acctCreateorUuid");
            return (Criteria) this;
        }

        public Criteria andAcctCreateorUuidGreaterThanOrEqualTo(String value) {
            addCriterion("acct_createor_uuid >=", value, "acctCreateorUuid");
            return (Criteria) this;
        }

        public Criteria andAcctCreateorUuidLessThan(String value) {
            addCriterion("acct_createor_uuid <", value, "acctCreateorUuid");
            return (Criteria) this;
        }

        public Criteria andAcctCreateorUuidLessThanOrEqualTo(String value) {
            addCriterion("acct_createor_uuid <=", value, "acctCreateorUuid");
            return (Criteria) this;
        }

        public Criteria andAcctCreateorUuidLike(String value) {
            addCriterion("acct_createor_uuid like", value, "acctCreateorUuid");
            return (Criteria) this;
        }

        public Criteria andAcctCreateorUuidNotLike(String value) {
            addCriterion("acct_createor_uuid not like", value, "acctCreateorUuid");
            return (Criteria) this;
        }

        public Criteria andAcctCreateorUuidIn(List<String> values) {
            addCriterion("acct_createor_uuid in", values, "acctCreateorUuid");
            return (Criteria) this;
        }

        public Criteria andAcctCreateorUuidNotIn(List<String> values) {
            addCriterion("acct_createor_uuid not in", values, "acctCreateorUuid");
            return (Criteria) this;
        }

        public Criteria andAcctCreateorUuidBetween(String value1, String value2) {
            addCriterion("acct_createor_uuid between", value1, value2, "acctCreateorUuid");
            return (Criteria) this;
        }

        public Criteria andAcctCreateorUuidNotBetween(String value1, String value2) {
            addCriterion("acct_createor_uuid not between", value1, value2, "acctCreateorUuid");
            return (Criteria) this;
        }

        public Criteria andAcctCreatetimeIsNull() {
            addCriterion("acct_createtime is null");
            return (Criteria) this;
        }

        public Criteria andAcctCreatetimeIsNotNull() {
            addCriterion("acct_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andAcctCreatetimeEqualTo(Date value) {
            addCriterion("acct_createtime =", value, "acctCreatetime");
            return (Criteria) this;
        }

        public Criteria andAcctCreatetimeNotEqualTo(Date value) {
            addCriterion("acct_createtime <>", value, "acctCreatetime");
            return (Criteria) this;
        }

        public Criteria andAcctCreatetimeGreaterThan(Date value) {
            addCriterion("acct_createtime >", value, "acctCreatetime");
            return (Criteria) this;
        }

        public Criteria andAcctCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("acct_createtime >=", value, "acctCreatetime");
            return (Criteria) this;
        }

        public Criteria andAcctCreatetimeLessThan(Date value) {
            addCriterion("acct_createtime <", value, "acctCreatetime");
            return (Criteria) this;
        }

        public Criteria andAcctCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("acct_createtime <=", value, "acctCreatetime");
            return (Criteria) this;
        }

        public Criteria andAcctCreatetimeIn(List<Date> values) {
            addCriterion("acct_createtime in", values, "acctCreatetime");
            return (Criteria) this;
        }

        public Criteria andAcctCreatetimeNotIn(List<Date> values) {
            addCriterion("acct_createtime not in", values, "acctCreatetime");
            return (Criteria) this;
        }

        public Criteria andAcctCreatetimeBetween(Date value1, Date value2) {
            addCriterion("acct_createtime between", value1, value2, "acctCreatetime");
            return (Criteria) this;
        }

        public Criteria andAcctCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("acct_createtime not between", value1, value2, "acctCreatetime");
            return (Criteria) this;
        }

        public Criteria andAcctModifierUuidIsNull() {
            addCriterion("acct_modifier_uuid is null");
            return (Criteria) this;
        }

        public Criteria andAcctModifierUuidIsNotNull() {
            addCriterion("acct_modifier_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andAcctModifierUuidEqualTo(String value) {
            addCriterion("acct_modifier_uuid =", value, "acctModifierUuid");
            return (Criteria) this;
        }

        public Criteria andAcctModifierUuidNotEqualTo(String value) {
            addCriterion("acct_modifier_uuid <>", value, "acctModifierUuid");
            return (Criteria) this;
        }

        public Criteria andAcctModifierUuidGreaterThan(String value) {
            addCriterion("acct_modifier_uuid >", value, "acctModifierUuid");
            return (Criteria) this;
        }

        public Criteria andAcctModifierUuidGreaterThanOrEqualTo(String value) {
            addCriterion("acct_modifier_uuid >=", value, "acctModifierUuid");
            return (Criteria) this;
        }

        public Criteria andAcctModifierUuidLessThan(String value) {
            addCriterion("acct_modifier_uuid <", value, "acctModifierUuid");
            return (Criteria) this;
        }

        public Criteria andAcctModifierUuidLessThanOrEqualTo(String value) {
            addCriterion("acct_modifier_uuid <=", value, "acctModifierUuid");
            return (Criteria) this;
        }

        public Criteria andAcctModifierUuidLike(String value) {
            addCriterion("acct_modifier_uuid like", value, "acctModifierUuid");
            return (Criteria) this;
        }

        public Criteria andAcctModifierUuidNotLike(String value) {
            addCriterion("acct_modifier_uuid not like", value, "acctModifierUuid");
            return (Criteria) this;
        }

        public Criteria andAcctModifierUuidIn(List<String> values) {
            addCriterion("acct_modifier_uuid in", values, "acctModifierUuid");
            return (Criteria) this;
        }

        public Criteria andAcctModifierUuidNotIn(List<String> values) {
            addCriterion("acct_modifier_uuid not in", values, "acctModifierUuid");
            return (Criteria) this;
        }

        public Criteria andAcctModifierUuidBetween(String value1, String value2) {
            addCriterion("acct_modifier_uuid between", value1, value2, "acctModifierUuid");
            return (Criteria) this;
        }

        public Criteria andAcctModifierUuidNotBetween(String value1, String value2) {
            addCriterion("acct_modifier_uuid not between", value1, value2, "acctModifierUuid");
            return (Criteria) this;
        }

        public Criteria andAcctModifiedtimeIsNull() {
            addCriterion("acct_modifiedtime is null");
            return (Criteria) this;
        }

        public Criteria andAcctModifiedtimeIsNotNull() {
            addCriterion("acct_modifiedtime is not null");
            return (Criteria) this;
        }

        public Criteria andAcctModifiedtimeEqualTo(Date value) {
            addCriterion("acct_modifiedtime =", value, "acctModifiedtime");
            return (Criteria) this;
        }

        public Criteria andAcctModifiedtimeNotEqualTo(Date value) {
            addCriterion("acct_modifiedtime <>", value, "acctModifiedtime");
            return (Criteria) this;
        }

        public Criteria andAcctModifiedtimeGreaterThan(Date value) {
            addCriterion("acct_modifiedtime >", value, "acctModifiedtime");
            return (Criteria) this;
        }

        public Criteria andAcctModifiedtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("acct_modifiedtime >=", value, "acctModifiedtime");
            return (Criteria) this;
        }

        public Criteria andAcctModifiedtimeLessThan(Date value) {
            addCriterion("acct_modifiedtime <", value, "acctModifiedtime");
            return (Criteria) this;
        }

        public Criteria andAcctModifiedtimeLessThanOrEqualTo(Date value) {
            addCriterion("acct_modifiedtime <=", value, "acctModifiedtime");
            return (Criteria) this;
        }

        public Criteria andAcctModifiedtimeIn(List<Date> values) {
            addCriterion("acct_modifiedtime in", values, "acctModifiedtime");
            return (Criteria) this;
        }

        public Criteria andAcctModifiedtimeNotIn(List<Date> values) {
            addCriterion("acct_modifiedtime not in", values, "acctModifiedtime");
            return (Criteria) this;
        }

        public Criteria andAcctModifiedtimeBetween(Date value1, Date value2) {
            addCriterion("acct_modifiedtime between", value1, value2, "acctModifiedtime");
            return (Criteria) this;
        }

        public Criteria andAcctModifiedtimeNotBetween(Date value1, Date value2) {
            addCriterion("acct_modifiedtime not between", value1, value2, "acctModifiedtime");
            return (Criteria) this;
        }

        public Criteria andAcctLastReconTimeIsNull() {
            addCriterion("acct_last_recon_time is null");
            return (Criteria) this;
        }

        public Criteria andAcctLastReconTimeIsNotNull() {
            addCriterion("acct_last_recon_time is not null");
            return (Criteria) this;
        }

        public Criteria andAcctLastReconTimeEqualTo(Date value) {
            addCriterion("acct_last_recon_time =", value, "acctLastReconTime");
            return (Criteria) this;
        }

        public Criteria andAcctLastReconTimeNotEqualTo(Date value) {
            addCriterion("acct_last_recon_time <>", value, "acctLastReconTime");
            return (Criteria) this;
        }

        public Criteria andAcctLastReconTimeGreaterThan(Date value) {
            addCriterion("acct_last_recon_time >", value, "acctLastReconTime");
            return (Criteria) this;
        }

        public Criteria andAcctLastReconTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("acct_last_recon_time >=", value, "acctLastReconTime");
            return (Criteria) this;
        }

        public Criteria andAcctLastReconTimeLessThan(Date value) {
            addCriterion("acct_last_recon_time <", value, "acctLastReconTime");
            return (Criteria) this;
        }

        public Criteria andAcctLastReconTimeLessThanOrEqualTo(Date value) {
            addCriterion("acct_last_recon_time <=", value, "acctLastReconTime");
            return (Criteria) this;
        }

        public Criteria andAcctLastReconTimeIn(List<Date> values) {
            addCriterion("acct_last_recon_time in", values, "acctLastReconTime");
            return (Criteria) this;
        }

        public Criteria andAcctLastReconTimeNotIn(List<Date> values) {
            addCriterion("acct_last_recon_time not in", values, "acctLastReconTime");
            return (Criteria) this;
        }

        public Criteria andAcctLastReconTimeBetween(Date value1, Date value2) {
            addCriterion("acct_last_recon_time between", value1, value2, "acctLastReconTime");
            return (Criteria) this;
        }

        public Criteria andAcctLastReconTimeNotBetween(Date value1, Date value2) {
            addCriterion("acct_last_recon_time not between", value1, value2, "acctLastReconTime");
            return (Criteria) this;
        }

        public Criteria andAcctNextTaskIsNull() {
            addCriterion("acct_next_task is null");
            return (Criteria) this;
        }

        public Criteria andAcctNextTaskIsNotNull() {
            addCriterion("acct_next_task is not null");
            return (Criteria) this;
        }

        public Criteria andAcctNextTaskEqualTo(String value) {
            addCriterion("acct_next_task =", value, "acctNextTask");
            return (Criteria) this;
        }

        public Criteria andAcctNextTaskNotEqualTo(String value) {
            addCriterion("acct_next_task <>", value, "acctNextTask");
            return (Criteria) this;
        }

        public Criteria andAcctNextTaskGreaterThan(String value) {
            addCriterion("acct_next_task >", value, "acctNextTask");
            return (Criteria) this;
        }

        public Criteria andAcctNextTaskGreaterThanOrEqualTo(String value) {
            addCriterion("acct_next_task >=", value, "acctNextTask");
            return (Criteria) this;
        }

        public Criteria andAcctNextTaskLessThan(String value) {
            addCriterion("acct_next_task <", value, "acctNextTask");
            return (Criteria) this;
        }

        public Criteria andAcctNextTaskLessThanOrEqualTo(String value) {
            addCriterion("acct_next_task <=", value, "acctNextTask");
            return (Criteria) this;
        }

        public Criteria andAcctNextTaskLike(String value) {
            addCriterion("acct_next_task like", value, "acctNextTask");
            return (Criteria) this;
        }

        public Criteria andAcctNextTaskNotLike(String value) {
            addCriterion("acct_next_task not like", value, "acctNextTask");
            return (Criteria) this;
        }

        public Criteria andAcctNextTaskIn(List<String> values) {
            addCriterion("acct_next_task in", values, "acctNextTask");
            return (Criteria) this;
        }

        public Criteria andAcctNextTaskNotIn(List<String> values) {
            addCriterion("acct_next_task not in", values, "acctNextTask");
            return (Criteria) this;
        }

        public Criteria andAcctNextTaskBetween(String value1, String value2) {
            addCriterion("acct_next_task between", value1, value2, "acctNextTask");
            return (Criteria) this;
        }

        public Criteria andAcctNextTaskNotBetween(String value1, String value2) {
            addCriterion("acct_next_task not between", value1, value2, "acctNextTask");
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