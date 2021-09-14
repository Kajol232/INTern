package com.muhammad.personal.intern.service.interfaces;

import com.muhammad.personal.intern.exceptions.NotFoundException;
import com.muhammad.personal.intern.exceptions.UnauthorizedException;
import com.muhammad.personal.intern.model.User;
import com.muhammad.personal.intern.model.dto.requests.UserLoginDTO;

public interface IAuthServices {
    User login(UserLoginDTO userLogin) throws UnauthorizedException, NotFoundException;
}
