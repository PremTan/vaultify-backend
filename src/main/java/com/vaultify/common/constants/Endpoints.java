package com.vaultify.common.constants;

public final class Endpoints {

    private Endpoints(){}

    public static final String API = "/api";
    public static final String VERSION = "/v1";
    public static final String BASE = API + VERSION;

    /* ================= AUTH ================= */

    public static final class Auth {

        private Auth(){}

        public static final String BASE = Endpoints.BASE + "/auth";

        public static final String REGISTER = "/register";
        public static final String LOGIN = "/login";
        public static final String VERIFY_EMAIL = "/verify-email";
        public static final String REFRESH_TOKEN = "/refresh-token";
        public static final String LOGOUT = "/logout";
    }

    /* ================= USER ================= */

    public static final class User {

        private User(){}

        public static final String BASE = Endpoints.BASE + "/users";

        public static final String PROFILE = "/profile";
    }

    /* ================= POLICY ================= */

    public static final class Policy {

        private Policy(){}

        public static final String BASE = Endpoints.BASE + "/policies";

        public static final String LIST = "";
        public static final String GET_BY_TYPE = "/{type}";
    }

}