package com.scwui.service.user;

import com.scwui.model.InstanceUser;
import com.scwui.model.ServiceInstanceList;
import com.scwui.service.common.CommonService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceInstanceService extends CommonService {

    public List getAll(String name) {

        HttpEntity<Object> entity = restClientUtil.restCommonHeaders(null);

        String url = propertiesUtil.getApiServiceInstances();

        ParameterizedTypeReference<ServiceInstanceList> responseType = new ParameterizedTypeReference<ServiceInstanceList>() {};

        ResponseEntity<List> response = restClientUtil.callRestApi(HttpMethod.GET, url+"/user?createUserId="+name, entity, List.class);

        logger.debug("response ::: " + response);

        List serviceInstancesList = response.getBody();

        return serviceInstancesList;
    }

    public List getAll(String instanceId, String userId) {

        HttpEntity<Object> entity = restClientUtil.restCommonHeaders(null);

        String url = propertiesUtil.getApiAuth();

        ParameterizedTypeReference<ServiceInstanceList> responseType = new ParameterizedTypeReference<ServiceInstanceList>() {};

        ResponseEntity<List> response = restClientUtil.callRestApi(HttpMethod.GET, url+"?instanceId="+instanceId+"&userId="+userId, entity, List.class);

        logger.debug("response ::: " + response);

        List serviceInstancesList = response.getBody();

        return serviceInstancesList;
    }

    public InstanceUser createInstanceUser(InstanceUser instanceUser) {

        HttpEntity<Object> entity = restClientUtil.restCommonHeaders(instanceUser);

        String url = propertiesUtil.getApiAuth();

        ResponseEntity<InstanceUser> response = restClientUtil.callRestApi(HttpMethod.POST, url, entity, InstanceUser.class);

        logger.debug("response ::: " + response);

        InstanceUser rtnInstanceUser = response.getBody();

        return rtnInstanceUser;
    }
}
