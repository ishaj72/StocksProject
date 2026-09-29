package com.example.constants;

public class Constants {
    
    /*Named Query */
    public static final String GET_ONBOARD_INFO_BY_USER_ID = "getOnboardInfoByUserId";
    public static final String GET_ONBOARD_LIST = "getOnboardList";
    public static final String GET_ADDRESS_INFO_BY_USER_ID= "getAddressInfoByUserId";

    /* Return message constants*/
    public static final String DATA_SAVED_SUCCESSFULLY = "Data saved successful. ";
    public static final String EXISITNG_DATA_UPDATED = "Data has been succesfully updates";
    public static final String DATA_NOT_SAVED = "Data is not saved. Some error Occurred";
    public static final String DATA_DELETED_SUCCESSFULLY = "Data has been deleted successfully";
    public static final String DATA_NOT_DELETED = "Data is not deleted";

    /*Error message constants */
    public static final String SOMETHING_WENT_WRONG = "Something went wrong.";
    public static final String ERROR_FETCHING_LIST = "There was some error while fetching the list.";
    public static final String NO_DATA_FOR_THIS_USER_ID ="No data present for this user id";

    /*Rabbit MQ Constants */

    /*roducer constants
    public static final String PRODUCER_EXCHANGE_NAME = "user.topic";
    public static final String PRODUCER_ROUTING_KEY = "user.info.send";

   // Consumer constants
    public static final String EXCHANGE_NAME = "auth.topic";
    public static final String ROUTING_KEY = "user.registered";
    public static final String QUEUE_NAME = "otp-notification-queue";

     */

    private Constants() {}
}
