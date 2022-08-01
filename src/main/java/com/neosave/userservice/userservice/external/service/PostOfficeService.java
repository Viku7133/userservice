package com.neosave.userservice.userservice.external.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.neosave.userservice.userservice.exception.CustomException;
import com.neosave.userservice.userservice.external.adapter.PostalPinCodeAdapter;
import com.neosave.userservice.userservice.external.response.PinCodeResponseEntity;
import com.neosave.userservice.userservice.external.response.PostOfficeEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class PostOfficeService {

  @Autowired
  private PostalPinCodeAdapter postalPinCodeAdapter;

  @Autowired
  private ObjectMapper objectMapper;


  public String getState(String pinCode) throws CustomException {
    List<PinCodeResponseEntity> pinCodeResponseEntities = postalPinCodeAdapter.getPostalPinCodeResponse(
        pinCode);
    if (CollectionUtils.isEmpty(pinCodeResponseEntities)) {
      return null;
    }
    PinCodeResponseEntity pinCodeResponseEntity = objectMapper.convertValue(
        pinCodeResponseEntities.get(0), PinCodeResponseEntity.class);
    List<PostOfficeEntity> postOfficeEntityList = pinCodeResponseEntity.getPostOfficeEntityList();
    if (CollectionUtils.isEmpty(postOfficeEntityList)) {
      return null;
    }
    return postOfficeEntityList.get(0).getState();
  }

}

