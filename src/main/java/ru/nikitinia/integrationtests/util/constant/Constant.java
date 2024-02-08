package ru.nikitinia.integrationtests.util.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constant {

    @UtilityClass
    public class kData {

        @UtilityClass
        public class RequestData {
            public static final String CLIENT_ID = "client_id";
            public static final String GRANT_TYPE = "grant_type";
            public static final String CLIENT_SECRET = "client_secret";
            public static final String CONTENT_TYPE_URLENCODED = "application/x-www-form-urlencoded";
        }

        @UtilityClass
        public class ResponseData {
            public static final String ACCESS_TOKEN = "access_token";
        }

    }

    @UtilityClass
    public class VaultData {

        @UtilityClass
        public class VaultToken {

            @UtilityClass
            public class ResponseData {
                public static final String PATH_TO_TOKEN = /*path to token -> folder.parameter*/;
            }

        }

        @UtilityClass
        public class VaultFolderData {

            @UtilityClass
            public class RequestData {
                public static final String HEADER_TOKEN_VAULT = "X-Vault-Token";
            }

        }

    }

}
