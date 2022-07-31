package com.neosave.userservice.userservice.external.adapter;

import com.neosave.userservice.userservice.exception.CustomException;
import com.neosave.userservice.userservice.external.response.PinCodeResponseEntity;
import java.util.List;

public interface PostalPinCodeAdapter {

  List<PinCodeResponseEntity> getPostalPinCodeResponse(String pinCode) throws CustomException;

}
