package ru.kpfu.fivehw.dto;

import ru.kpfu.fivehw.models.User;

import java.util.Objects;

public class ResponseUserDto {
    private String message;
    private User data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseUserDto that = (ResponseUserDto) o;
        return Objects.equals(message, that.message) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, data);
    }
}
