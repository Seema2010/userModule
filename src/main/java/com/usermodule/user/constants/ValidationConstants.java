package com.usermodule.user.constants;

public class ValidationConstants {

    private ValidationConstants() {
        throw new IllegalStateException("ValidationConstants class");
    }

    public static final String INVALID_USER_USERNAME = "User UserName should not be Empty";
    public static final String INVALID_APP_DATA = "App data should not be Empty";
    public static final String INVALID_USERNAME_SIZE = "User UserName size in invalid";
    public static final String INVALID_APP_NAME = "App name should not be Empty";
    public static final String INVALID_USER_EMAIL = "User Email should not be Empty";
    public static final String INVALID_USER_PASSWORD = "User Password should not be Empty";

    public static final String SUCCESS = "200";
    public static final String FAILURE = "400";

    public static final String INVALID_PASSED_TOKEN = "Passed Token for validation shouldn't be blank.";

    public static final String INVALID_VALIDATION_URL = "Passed URL for validation shouldn't be blank.";

    public static final String INVALID_APP_TYPE = "App Type is Invalid for this request.";

    public static final String APP_TYPE_CONSUMER = "CONSUMER";
    public static final String APP_TYPE_PRODUCER = "PRODUCER";

    //Email Errors (10,000)
    public static final String INVALID_APP_API_URL = "API Scope URL is either blank or null";

    public static final String EMPTY_APP_API = "No API Registered for this App.";

    public static final String APP_API_NOT_REGISTERED = "App doesn't have access to this Api. Please raise a access.";

    public static final String INVALID_HMAC_GEN = "Error in HMac, please check your details!!!";

    public static final String NO_API_ACCESS_FOUND_FOR_USER = "You don't have access to this API.";
    public static final String INVALID_EMAIL = "Email is invalid";
    public static final String INVALID_EMAIL_BLOCKED = "This email is blocked!!!";
    public static final String EMAIL_TEMP_PRESENT = "Email is already used, Confirmation pending. Please confirm your Email!!!";
    public static final String EMAIL_ALREADY_USED = "Email is already used!!!";
    public static final String INVALID_ROLE_NAME = "Role Name should not be Empty";
    public static final String INVALID_ROLE_SIZE = "Role Code should contain maximum two alphabets";
    public static final String INVALID_ROLE_CODE = "Role Code should not be Empty";
    public static final String INVALID_USER_FIRSTNAME = "User First Name should not be Empty";
    public static final String INVALID_USER_GENDER = "User Gender should not be Empty";
    public static final String INVALID_USER_ROLE = "User Role should not be Empty";
    public static final String INVALID_USER_COUNTRY = "User Role should not be Empty";
    public static final String TOKEN_CREATION_SUCCESS = "Token Creation Successful.";
    public static final String TOKEN_CREATION_FAILURE = "Token Creation Failure.";
    public static final String TOKEN_VALIDATION_FAILURE = "Token Validation Failed.";
    public static final String TOKEN_VALIDATION_SUCCESS = "Token Validation Success.";
    public static final String TOKEN_INVALID_USERNAME = "Token is Invalid, doesn't contain UserName.";
    public static final String TOKEN_INVALID_USER_DETAILS = "Request Token doesn't match with User Details!!!";
    public static final String TOKEN_INVALID_NULL = "Request UserName is Null or Security Context Holder Details are Null!!!";
    public static final String USER_CREATION_SUCCESS = "User Creation Successful.";
    public static final String USER_CREATION_FAILURE = "User Creation Failure.";
    public static final String INVALID_VALIDATION_CODE = "20012";
    public static final String AUTHENTICATION_SUCCESS = "Authentication Successful";
    public static final String INVALID_APP_API_URL_SIZE = "API Url size is not valid";
    public static final String INVALID_APP_NAME_SIZE = "App name size is not valid";
    public static final String INVALID_USER_LASTNAME = "User Last Name should not be Empty";
    public static final String ERROR_ROLE_CREATE = "Error creating Role.";
    public static final String SUCCESS_ROLE_CREATE = "Role creation Successful.";
    public static final String ERROR_APP_API_REG = "Error in Registering API for App.";
    public static final String SUCCESS_APP_API_REG = "API Registered for App Successfully.";
    public static final String ERROR_API_ROLE_REG = "Error in associating Role to API.";
    public static final String API_ROLE_ASSOC_SUCCESS = "Role Association to API Successful.";

    public static final String FAILURE_CONTAINS_JAVASCRIPT = "Input String contains Javascript, Cannot process further!!!";
    public static final String FAILURE_CONTAINS_FOUL_WORDS = "Input String contains Unapproved words, Cannot process further!!!";
    public static final String FAILURE_CONTAINS_FOUL_WORDS_FIRSTNAME = "Input String contains Unapproved words in first Name, Cannot process further!!!";
    public static final String FAILURE_CONTAINS_FOUL_WORDS_LASTNAME = "Input String contains Unapproved words in Last Name, Cannot process further!!!";
    public static final String FAILURE_CONTAINS_JAVASCRIPT_FIRSTNAME = "Input String contains Javascript in first Name, Cannot process further!!!";
    public static final String FAILURE_CONTAINS_JAVASCRIPT_LASTNAME = "Input String contains Javascript in last Name, Cannot process further!!!";

    //Event Details Errors (30,000)
    public static final String INVALID_EVENT_NAME = "Event Name should not be Empty";
    public static final String INVALID_EVENT_START_TIME = "Event Start time is Invalid";
    public static final String INVALID_EVENT_END_TIME = "Event End time is Invalid";

    //Product Details Related Error (40,000)

    //Country Details Related Errors (50,000)
    public static final String INVALID_COUNTRY_ID = "Country ID can't be blank";
    public static final String INVALID_COUNTRY_NAME_ENG = "Country name in English Can't be blank";
    public static final String INVALID_COUNTRY_NAME_SPN = "Country name in Spanish Can't be blank";
    public static final String INVALID_COUNTRY_ISO_CODE = "Country Code Can't be blank";
    public static final String COUNTRY_CREATED_SUCCESS = "Country Created Successfully";
    public static final String COUNTRY_CREATED_FAILURE = "Country Creation Failed";
    public static final String COUNTRY_FOUND_SUCCESS = "Country Fount Successfully";
    public static final String COUNTRY_FOUND_FAILURE = "Country not found";

    public static final String ERROR_IN_ENCRYPTION = "Error is Encryption, with error messages: {}";
    public static final String ERROR_IN_DECRYPTION = "Error is Decryption, with error messages: {}";

    public static final String HMAC_VALIDATION_FAILED = "HMAC_VALIDATION_FAILED";

}
