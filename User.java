package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {


        private int id;
        private String name;
        private String username;
        private String email;
        private org.example.dto.User.Address address;

    public User() {

    }


    @Getter
        @Setter
        @AllArgsConstructor
        public static class Address {
            public String street;
            private String suite;
            private String city;
            private String zipcode;
            private org.example.dto.User.Address.Geo geo;

            public Address() {

            }

            @Getter
            @Setter
            @AllArgsConstructor
            public static class Geo {
                private double lat;
                private double lng;

                public Geo() {

                }
            }

        }

        private String phone;
        private String website;
        private org.example.dto.User.Company company;

        @Getter
        @Setter
        @AllArgsConstructor
        public static class Company {
            private String name;
            private String catchPhrase;
            private String bs;

            public Company() {

            }
        }
    }

