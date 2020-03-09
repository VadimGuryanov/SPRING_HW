package ru.kpfu.fivehw.dto;

import java.util.Date;
import java.util.Objects;

public class UserDto {

    private String email;
    private String password;
    private String passwordRepeat;
    private String country;
    private String gender;
    private String birthday;
    private Boolean agreement;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(email, userDto.email) &&
                Objects.equals(password, userDto.password) &&
                Objects.equals(passwordRepeat, userDto.passwordRepeat) &&
                Objects.equals(country, userDto.country) &&
                Objects.equals(gender, userDto.gender) &&
                Objects.equals(birthday, userDto.birthday) &&
                Objects.equals(agreement, userDto.agreement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, passwordRepeat, country, gender, birthday, agreement);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Boolean getAgreement() {
        return agreement;
    }

    public void setAgreement(Boolean argeement) {
        this.agreement = argeement;
    }
}
