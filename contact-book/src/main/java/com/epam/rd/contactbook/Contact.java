package com.epam.rd.contactbook;

public class Contact {

    private static String nameString;
    private ContactInfo name;
    private ContactInfo phoneNumber;
    private ContactInfo[] emails;
    private ContactInfo[] socials;
    private final int emailsLimit = 3;
    private final int socialsLimit = 5;
    private int emailsCounter;
    private int socialsCounter;

    private class NameContactInfo implements ContactInfo {

        @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return Contact.nameString;
        }

        @Override
        public String toString() {
            return getTitle() + ": " + getValue();
        }
    }

    public static class Email implements ContactInfo {

        String email;

        public Email(String email) {
            this.email = email;
        }

        @Override
        public String getTitle() {
            return "Email";
        }

        @Override
        public String getValue() {
            return email;
        }

        @Override
        public String toString() {
            return getTitle() + ": " + getValue();
        }
    }

    public static class Social implements ContactInfo {

        String socialMedia;
        String account;

        public Social(String socialMedia, String account) {
            this.socialMedia = socialMedia;
            this.account = account;
        }

        @Override
        public String getTitle() {
            return socialMedia;
        }

        @Override
        public String getValue() {
            return account;
        }

        @Override
        public String toString() {
            return getTitle() + ": " + getValue();
        }
    }

    public Contact(String contactName) {
        nameString = contactName;
        this.name = new NameContactInfo();
        this.emails = new Email[this.emailsLimit];
        this.socials = new Social[this.socialsLimit];
        this.socialsCounter = 0;
        this.emailsCounter = 0;
    }

    public void rename(String newName) {
        if(newName != null && newName.length() != 0)
            nameString = newName;
    }

    public Email addEmail(String localPart, String domain) {
        if(emailsCounter < emailsLimit) {
            Email email = new Email(localPart + "@" + domain);
            emails[emailsCounter] = email;
            emailsCounter++;
            return email;
        } else {
            return null;
        }
    }


    public Email addEpamEmail(String firstname, String lastname) {
        if(emailsCounter < emailsLimit) {
            Email epamEmail = new Email(firstname + "_" + lastname + "@epam.com") {
                @Override
                public String getTitle() {
                    return "Epam Email";
                }
            };
            emails[emailsCounter] = epamEmail;
            emailsCounter++;
            return epamEmail;
        } else {
            return null;
        }
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        if(phoneNumber != null)
            return null;
        else {
            phoneNumber = new ContactInfo() {

                String phone = "+" + code + " " + number;

                @Override
                public String getTitle() {
                    return "Tel";
                }

                @Override
                public String getValue() {
                    return phone;
                }

                @Override
                public String toString() {
                    return getTitle() + ": " + getValue();
                }
            };

            return phoneNumber;
        }
    }


    public Social addTwitter(String twitterId) {
        return addSocialMedia("Twitter", twitterId);
    }

    public Social addInstagram(String instagramId) {
        return addSocialMedia("Instagram", instagramId);
    }

    public Social addSocialMedia(String title, String id) {
        if(socialsCounter < socialsLimit) {
            Social social = new Social(title, id);
            socials[socialsCounter] = social;
            socialsCounter++;
            return social;
        } else {
            return null;
        }
    }

    public ContactInfo[] getInfo() {
        ContactInfo[] infoWithNulls = new ContactInfo[10];
        int nullCounter = 0;
        infoWithNulls[0] = name;
        infoWithNulls[1] = phoneNumber;
        for (int i = 0; i < emailsLimit; i++) {
            infoWithNulls[i + 2] = emails[i];
        }
        for (int i = 0; i < socialsLimit; i++) {
            infoWithNulls[i + 2 + emailsLimit] = socials[i];
        }
        for (ContactInfo contactInfo : infoWithNulls) {
            if(contactInfo == null)
                nullCounter++;
        }
        ContactInfo[] info = new ContactInfo[10 - nullCounter];
        int i = 0;
        for (ContactInfo contactInfo : infoWithNulls) {
            if(contactInfo != null) {
                info[i] = contactInfo;
                i++;
            }
        }
        return info;
    }

}
