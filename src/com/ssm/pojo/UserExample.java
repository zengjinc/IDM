package com.ssm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNull() {
            addCriterion("user_pwd is null");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNotNull() {
            addCriterion("user_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andUserPwdEqualTo(String value) {
            addCriterion("user_pwd =", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotEqualTo(String value) {
            addCriterion("user_pwd <>", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThan(String value) {
            addCriterion("user_pwd >", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThanOrEqualTo(String value) {
            addCriterion("user_pwd >=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThan(String value) {
            addCriterion("user_pwd <", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThanOrEqualTo(String value) {
            addCriterion("user_pwd <=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLike(String value) {
            addCriterion("user_pwd like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotLike(String value) {
            addCriterion("user_pwd not like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdIn(List<String> values) {
            addCriterion("user_pwd in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotIn(List<String> values) {
            addCriterion("user_pwd not in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdBetween(String value1, String value2) {
            addCriterion("user_pwd between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotBetween(String value1, String value2) {
            addCriterion("user_pwd not between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserEmployeeIdIsNull() {
            addCriterion("user_employee_id is null");
            return (Criteria) this;
        }

        public Criteria andUserEmployeeIdIsNotNull() {
            addCriterion("user_employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmployeeIdEqualTo(String value) {
            addCriterion("user_employee_id =", value, "userEmployeeId");
            return (Criteria) this;
        }

        public Criteria andUserEmployeeIdNotEqualTo(String value) {
            addCriterion("user_employee_id <>", value, "userEmployeeId");
            return (Criteria) this;
        }

        public Criteria andUserEmployeeIdGreaterThan(String value) {
            addCriterion("user_employee_id >", value, "userEmployeeId");
            return (Criteria) this;
        }

        public Criteria andUserEmployeeIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_employee_id >=", value, "userEmployeeId");
            return (Criteria) this;
        }

        public Criteria andUserEmployeeIdLessThan(String value) {
            addCriterion("user_employee_id <", value, "userEmployeeId");
            return (Criteria) this;
        }

        public Criteria andUserEmployeeIdLessThanOrEqualTo(String value) {
            addCriterion("user_employee_id <=", value, "userEmployeeId");
            return (Criteria) this;
        }

        public Criteria andUserEmployeeIdLike(String value) {
            addCriterion("user_employee_id like", value, "userEmployeeId");
            return (Criteria) this;
        }

        public Criteria andUserEmployeeIdNotLike(String value) {
            addCriterion("user_employee_id not like", value, "userEmployeeId");
            return (Criteria) this;
        }

        public Criteria andUserEmployeeIdIn(List<String> values) {
            addCriterion("user_employee_id in", values, "userEmployeeId");
            return (Criteria) this;
        }

        public Criteria andUserEmployeeIdNotIn(List<String> values) {
            addCriterion("user_employee_id not in", values, "userEmployeeId");
            return (Criteria) this;
        }

        public Criteria andUserEmployeeIdBetween(String value1, String value2) {
            addCriterion("user_employee_id between", value1, value2, "userEmployeeId");
            return (Criteria) this;
        }

        public Criteria andUserEmployeeIdNotBetween(String value1, String value2) {
            addCriterion("user_employee_id not between", value1, value2, "userEmployeeId");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("user_email is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("user_email is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("user_email =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("user_email <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("user_email >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("user_email >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("user_email <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("user_email <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("user_email like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("user_email not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("user_email in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("user_email not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("user_email between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("user_email not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserMoibleIsNull() {
            addCriterion("user_moible is null");
            return (Criteria) this;
        }

        public Criteria andUserMoibleIsNotNull() {
            addCriterion("user_moible is not null");
            return (Criteria) this;
        }

        public Criteria andUserMoibleEqualTo(String value) {
            addCriterion("user_moible =", value, "userMoible");
            return (Criteria) this;
        }

        public Criteria andUserMoibleNotEqualTo(String value) {
            addCriterion("user_moible <>", value, "userMoible");
            return (Criteria) this;
        }

        public Criteria andUserMoibleGreaterThan(String value) {
            addCriterion("user_moible >", value, "userMoible");
            return (Criteria) this;
        }

        public Criteria andUserMoibleGreaterThanOrEqualTo(String value) {
            addCriterion("user_moible >=", value, "userMoible");
            return (Criteria) this;
        }

        public Criteria andUserMoibleLessThan(String value) {
            addCriterion("user_moible <", value, "userMoible");
            return (Criteria) this;
        }

        public Criteria andUserMoibleLessThanOrEqualTo(String value) {
            addCriterion("user_moible <=", value, "userMoible");
            return (Criteria) this;
        }

        public Criteria andUserMoibleLike(String value) {
            addCriterion("user_moible like", value, "userMoible");
            return (Criteria) this;
        }

        public Criteria andUserMoibleNotLike(String value) {
            addCriterion("user_moible not like", value, "userMoible");
            return (Criteria) this;
        }

        public Criteria andUserMoibleIn(List<String> values) {
            addCriterion("user_moible in", values, "userMoible");
            return (Criteria) this;
        }

        public Criteria andUserMoibleNotIn(List<String> values) {
            addCriterion("user_moible not in", values, "userMoible");
            return (Criteria) this;
        }

        public Criteria andUserMoibleBetween(String value1, String value2) {
            addCriterion("user_moible between", value1, value2, "userMoible");
            return (Criteria) this;
        }

        public Criteria andUserMoibleNotBetween(String value1, String value2) {
            addCriterion("user_moible not between", value1, value2, "userMoible");
            return (Criteria) this;
        }

        public Criteria andUserPhonenumberIsNull() {
            addCriterion("user_phonenumber is null");
            return (Criteria) this;
        }

        public Criteria andUserPhonenumberIsNotNull() {
            addCriterion("user_phonenumber is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhonenumberEqualTo(String value) {
            addCriterion("user_phonenumber =", value, "userPhonenumber");
            return (Criteria) this;
        }

        public Criteria andUserPhonenumberNotEqualTo(String value) {
            addCriterion("user_phonenumber <>", value, "userPhonenumber");
            return (Criteria) this;
        }

        public Criteria andUserPhonenumberGreaterThan(String value) {
            addCriterion("user_phonenumber >", value, "userPhonenumber");
            return (Criteria) this;
        }

        public Criteria andUserPhonenumberGreaterThanOrEqualTo(String value) {
            addCriterion("user_phonenumber >=", value, "userPhonenumber");
            return (Criteria) this;
        }

        public Criteria andUserPhonenumberLessThan(String value) {
            addCriterion("user_phonenumber <", value, "userPhonenumber");
            return (Criteria) this;
        }

        public Criteria andUserPhonenumberLessThanOrEqualTo(String value) {
            addCriterion("user_phonenumber <=", value, "userPhonenumber");
            return (Criteria) this;
        }

        public Criteria andUserPhonenumberLike(String value) {
            addCriterion("user_phonenumber like", value, "userPhonenumber");
            return (Criteria) this;
        }

        public Criteria andUserPhonenumberNotLike(String value) {
            addCriterion("user_phonenumber not like", value, "userPhonenumber");
            return (Criteria) this;
        }

        public Criteria andUserPhonenumberIn(List<String> values) {
            addCriterion("user_phonenumber in", values, "userPhonenumber");
            return (Criteria) this;
        }

        public Criteria andUserPhonenumberNotIn(List<String> values) {
            addCriterion("user_phonenumber not in", values, "userPhonenumber");
            return (Criteria) this;
        }

        public Criteria andUserPhonenumberBetween(String value1, String value2) {
            addCriterion("user_phonenumber between", value1, value2, "userPhonenumber");
            return (Criteria) this;
        }

        public Criteria andUserPhonenumberNotBetween(String value1, String value2) {
            addCriterion("user_phonenumber not between", value1, value2, "userPhonenumber");
            return (Criteria) this;
        }

        public Criteria andUserResUuidIsNull() {
            addCriterion("user_res_uuid is null");
            return (Criteria) this;
        }

        public Criteria andUserResUuidIsNotNull() {
            addCriterion("user_res_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUserResUuidEqualTo(String value) {
            addCriterion("user_res_uuid =", value, "userResUuid");
            return (Criteria) this;
        }

        public Criteria andUserResUuidNotEqualTo(String value) {
            addCriterion("user_res_uuid <>", value, "userResUuid");
            return (Criteria) this;
        }

        public Criteria andUserResUuidGreaterThan(String value) {
            addCriterion("user_res_uuid >", value, "userResUuid");
            return (Criteria) this;
        }

        public Criteria andUserResUuidGreaterThanOrEqualTo(String value) {
            addCriterion("user_res_uuid >=", value, "userResUuid");
            return (Criteria) this;
        }

        public Criteria andUserResUuidLessThan(String value) {
            addCriterion("user_res_uuid <", value, "userResUuid");
            return (Criteria) this;
        }

        public Criteria andUserResUuidLessThanOrEqualTo(String value) {
            addCriterion("user_res_uuid <=", value, "userResUuid");
            return (Criteria) this;
        }

        public Criteria andUserResUuidLike(String value) {
            addCriterion("user_res_uuid like", value, "userResUuid");
            return (Criteria) this;
        }

        public Criteria andUserResUuidNotLike(String value) {
            addCriterion("user_res_uuid not like", value, "userResUuid");
            return (Criteria) this;
        }

        public Criteria andUserResUuidIn(List<String> values) {
            addCriterion("user_res_uuid in", values, "userResUuid");
            return (Criteria) this;
        }

        public Criteria andUserResUuidNotIn(List<String> values) {
            addCriterion("user_res_uuid not in", values, "userResUuid");
            return (Criteria) this;
        }

        public Criteria andUserResUuidBetween(String value1, String value2) {
            addCriterion("user_res_uuid between", value1, value2, "userResUuid");
            return (Criteria) this;
        }

        public Criteria andUserResUuidNotBetween(String value1, String value2) {
            addCriterion("user_res_uuid not between", value1, value2, "userResUuid");
            return (Criteria) this;
        }

        public Criteria andUserCreatorIsNull() {
            addCriterion("user_creator is null");
            return (Criteria) this;
        }

        public Criteria andUserCreatorIsNotNull() {
            addCriterion("user_creator is not null");
            return (Criteria) this;
        }

        public Criteria andUserCreatorEqualTo(String value) {
            addCriterion("user_creator =", value, "userCreator");
            return (Criteria) this;
        }

        public Criteria andUserCreatorNotEqualTo(String value) {
            addCriterion("user_creator <>", value, "userCreator");
            return (Criteria) this;
        }

        public Criteria andUserCreatorGreaterThan(String value) {
            addCriterion("user_creator >", value, "userCreator");
            return (Criteria) this;
        }

        public Criteria andUserCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("user_creator >=", value, "userCreator");
            return (Criteria) this;
        }

        public Criteria andUserCreatorLessThan(String value) {
            addCriterion("user_creator <", value, "userCreator");
            return (Criteria) this;
        }

        public Criteria andUserCreatorLessThanOrEqualTo(String value) {
            addCriterion("user_creator <=", value, "userCreator");
            return (Criteria) this;
        }

        public Criteria andUserCreatorLike(String value) {
            addCriterion("user_creator like", value, "userCreator");
            return (Criteria) this;
        }

        public Criteria andUserCreatorNotLike(String value) {
            addCriterion("user_creator not like", value, "userCreator");
            return (Criteria) this;
        }

        public Criteria andUserCreatorIn(List<String> values) {
            addCriterion("user_creator in", values, "userCreator");
            return (Criteria) this;
        }

        public Criteria andUserCreatorNotIn(List<String> values) {
            addCriterion("user_creator not in", values, "userCreator");
            return (Criteria) this;
        }

        public Criteria andUserCreatorBetween(String value1, String value2) {
            addCriterion("user_creator between", value1, value2, "userCreator");
            return (Criteria) this;
        }

        public Criteria andUserCreatorNotBetween(String value1, String value2) {
            addCriterion("user_creator not between", value1, value2, "userCreator");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeIsNull() {
            addCriterion("user_createtime is null");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeIsNotNull() {
            addCriterion("user_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeEqualTo(Date value) {
            addCriterion("user_createtime =", value, "userCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeNotEqualTo(Date value) {
            addCriterion("user_createtime <>", value, "userCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeGreaterThan(Date value) {
            addCriterion("user_createtime >", value, "userCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("user_createtime >=", value, "userCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeLessThan(Date value) {
            addCriterion("user_createtime <", value, "userCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("user_createtime <=", value, "userCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeIn(List<Date> values) {
            addCriterion("user_createtime in", values, "userCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeNotIn(List<Date> values) {
            addCriterion("user_createtime not in", values, "userCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeBetween(Date value1, Date value2) {
            addCriterion("user_createtime between", value1, value2, "userCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("user_createtime not between", value1, value2, "userCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserModifierIsNull() {
            addCriterion("user_modifier is null");
            return (Criteria) this;
        }

        public Criteria andUserModifierIsNotNull() {
            addCriterion("user_modifier is not null");
            return (Criteria) this;
        }

        public Criteria andUserModifierEqualTo(String value) {
            addCriterion("user_modifier =", value, "userModifier");
            return (Criteria) this;
        }

        public Criteria andUserModifierNotEqualTo(String value) {
            addCriterion("user_modifier <>", value, "userModifier");
            return (Criteria) this;
        }

        public Criteria andUserModifierGreaterThan(String value) {
            addCriterion("user_modifier >", value, "userModifier");
            return (Criteria) this;
        }

        public Criteria andUserModifierGreaterThanOrEqualTo(String value) {
            addCriterion("user_modifier >=", value, "userModifier");
            return (Criteria) this;
        }

        public Criteria andUserModifierLessThan(String value) {
            addCriterion("user_modifier <", value, "userModifier");
            return (Criteria) this;
        }

        public Criteria andUserModifierLessThanOrEqualTo(String value) {
            addCriterion("user_modifier <=", value, "userModifier");
            return (Criteria) this;
        }

        public Criteria andUserModifierLike(String value) {
            addCriterion("user_modifier like", value, "userModifier");
            return (Criteria) this;
        }

        public Criteria andUserModifierNotLike(String value) {
            addCriterion("user_modifier not like", value, "userModifier");
            return (Criteria) this;
        }

        public Criteria andUserModifierIn(List<String> values) {
            addCriterion("user_modifier in", values, "userModifier");
            return (Criteria) this;
        }

        public Criteria andUserModifierNotIn(List<String> values) {
            addCriterion("user_modifier not in", values, "userModifier");
            return (Criteria) this;
        }

        public Criteria andUserModifierBetween(String value1, String value2) {
            addCriterion("user_modifier between", value1, value2, "userModifier");
            return (Criteria) this;
        }

        public Criteria andUserModifierNotBetween(String value1, String value2) {
            addCriterion("user_modifier not between", value1, value2, "userModifier");
            return (Criteria) this;
        }

        public Criteria andUserModifiedtimeIsNull() {
            addCriterion("user_modifiedtime is null");
            return (Criteria) this;
        }

        public Criteria andUserModifiedtimeIsNotNull() {
            addCriterion("user_modifiedtime is not null");
            return (Criteria) this;
        }

        public Criteria andUserModifiedtimeEqualTo(Date value) {
            addCriterionForJDBCTime("user_modifiedtime =", value, "userModifiedtime");
            return (Criteria) this;
        }

        public Criteria andUserModifiedtimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("user_modifiedtime <>", value, "userModifiedtime");
            return (Criteria) this;
        }

        public Criteria andUserModifiedtimeGreaterThan(Date value) {
            addCriterionForJDBCTime("user_modifiedtime >", value, "userModifiedtime");
            return (Criteria) this;
        }

        public Criteria andUserModifiedtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("user_modifiedtime >=", value, "userModifiedtime");
            return (Criteria) this;
        }

        public Criteria andUserModifiedtimeLessThan(Date value) {
            addCriterionForJDBCTime("user_modifiedtime <", value, "userModifiedtime");
            return (Criteria) this;
        }

        public Criteria andUserModifiedtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("user_modifiedtime <=", value, "userModifiedtime");
            return (Criteria) this;
        }

        public Criteria andUserModifiedtimeIn(List<Date> values) {
            addCriterionForJDBCTime("user_modifiedtime in", values, "userModifiedtime");
            return (Criteria) this;
        }

        public Criteria andUserModifiedtimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("user_modifiedtime not in", values, "userModifiedtime");
            return (Criteria) this;
        }

        public Criteria andUserModifiedtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("user_modifiedtime between", value1, value2, "userModifiedtime");
            return (Criteria) this;
        }

        public Criteria andUserModifiedtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("user_modifiedtime not between", value1, value2, "userModifiedtime");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNull() {
            addCriterion("user_status is null");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNotNull() {
            addCriterion("user_status is not null");
            return (Criteria) this;
        }

        public Criteria andUserStatusEqualTo(Integer value) {
            addCriterion("user_status =", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotEqualTo(Integer value) {
            addCriterion("user_status <>", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThan(Integer value) {
            addCriterion("user_status >", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_status >=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThan(Integer value) {
            addCriterion("user_status <", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThanOrEqualTo(Integer value) {
            addCriterion("user_status <=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusIn(List<Integer> values) {
            addCriterion("user_status in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotIn(List<Integer> values) {
            addCriterion("user_status not in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusBetween(Integer value1, Integer value2) {
            addCriterion("user_status between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("user_status not between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("user_type like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("user_type not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("user_type not between", value1, value2, "userType");
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