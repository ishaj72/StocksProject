package com.example.constants;

public class Constants {
    
    /*Named Query */
    public static final String GET_ONBOARD_INFO_BY_USER_ID = "getOnboardInfoByUserId";

    /*Error message constants */
    public static final String SOMETHING_WENT_WRONG = "Something went wrong.";

    /*Rabbit MQ Constants */

    //Producer constants
    public static final String PRODUCER_EXCHANGE_NAME = "user.topic";
    public static final String PRODUCER_ROUTING_KEY = "user.info.send";

   // Consumer constants
    public static final String EXCHANGE_NAME = "auth.topic";
    public static final String ROUTING_KEY = "user.registered";
    public static final String QUEUE_NAME = "otp-notification-queue";

    private Constants() {}
}
