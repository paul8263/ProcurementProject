package com.paul.service.def;

import com.paul.domain.User;
import com.paul.web.exception.ItemNotFoundException;

/**
 * Created by paulzhang on 20/12/2016.
 */
public interface UserHelper {
    User getUserFromAuthentication() throws ItemNotFoundException;
}
