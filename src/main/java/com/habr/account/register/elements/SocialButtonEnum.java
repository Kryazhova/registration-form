package com.habr.account.register.elements;

public enum SocialButtonEnum {
        FACEBOOK("fb"),
        VK("vk"),
        TWITTER("twitter"),
        GIT("git"),
        LIVE("live"),
        GOOGLE("google");

        private String text;

        SocialButtonEnum(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
}
