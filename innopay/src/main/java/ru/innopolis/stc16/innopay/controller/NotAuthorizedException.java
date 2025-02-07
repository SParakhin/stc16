package ru.innopolis.stc16.innopay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Неверно указаны имя магазина или ключ")
class NotAuthorizedException extends RuntimeException {
}
