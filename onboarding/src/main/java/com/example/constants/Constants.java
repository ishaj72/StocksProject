package com.example.constants;

public class Constants {
    
    /*Named Query */
    public static final String GET_ONBOARD_INFO_BY_USER_ID = "getOnboardInfoByUserId";
    public static final String GET_ONBOARD_LIST = "getOnboardList";

    /*Error message constants */
    public static final String SOMETHING_WENT_WRONG = "Something went wrong.";
    public static final String ERROR_FETCHING_LIST = "There was some error while fetch the list.";
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
