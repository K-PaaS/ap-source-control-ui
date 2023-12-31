package com.scwui.controller.user;

import com.scwui.common.exception.ScWebUIexceptionException;
import com.scwui.common.util.Common;
import com.scwui.controller.common.CommonController;
import com.scwui.service.cf.security.DashboardAuthenticationDetails;
import com.scwui.service.user.PermissionService;
import com.scwui.service.user.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"/user"})
public class PermissionController extends CommonController{

    @Autowired
    PermissionService permissionService;
    @Autowired
    RepositoryService repositoryService;


   /* public PermissionController(PermissionService permissionService, RepositoryService repositoryService) {
        this.permissionService = permissionService;
        this.repositoryService = repositoryService;
    }
*/
    /**
     * ex)http://localhost:9092/user/permission/1
     * @param repoId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/permission/{repoId}", method = RequestMethod.GET)
    public ModelAndView servicePermissionList(@PathVariable String repoId, HttpServletRequest request) throws ScWebUIexceptionException{
        logger.debug(""+Common.convertMapByRequest(request));
        List<Map> lstPermission = permissionService.getPermissionsByRepoId(Integer.parseInt(repoId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("lstPermission", lstPermission);
        modelAndView.addObject("title", "사용자 목록");
        modelAndView.setViewName("/user/permission/permissionList");

        return modelAndView;
    }

    /**
     * 참여자 추가
     * @param repoId
     * @param map
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/permission/{repoId}", method = RequestMethod.PUT)
    @ResponseBody
    public Map invitePermission(@PathVariable("repoId") String repoId,  @RequestBody Map map) throws ScWebUIexceptionException{

        ResponseEntity responseEntity = permissionService.putPermission(repoId, map);
        Map map1 = new HashMap();
        map1.put("status", responseEntity.getStatusCodeValue());
        map1.put("response", responseEntity);
        return map1;
    }

    /**
     * 참여자 삭제
     * @param no
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/permission/{no}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deletePermission(@PathVariable("no") String no) throws ScWebUIexceptionException{

        ResponseEntity responseEntity = permissionService.deletePermissionsByNo(Integer.parseInt(no));
        return new ResponseEntity("{}",responseEntity.getStatusCode());
    }

    @GetMapping("/permissions/{repositoryId}")
    @ResponseBody
    public Map getPermissionByRepositoryId(@PathVariable("repositoryId") String repositoryId, HttpServletRequest request) {
        Map mapByRequest = Common.convertMapByRequest(request);
        Map map = repositoryService.getPermissionByRepositoryId(repositoryId, mapByRequest);
        return map;
    }

    /**
     * instanceId에 대한 사용자와 repository 참여 정보를 가져를 검색하여 가져온다.
     * @param searchUserId
     * @param repositoryId
     * @return
     */
    @GetMapping("/searchPermissions/")
    @ResponseBody
    public Map getPermissionByRepositoryIdAndSearchUserId(@RequestParam(value = "searchUserId") String searchUserId
               ,@RequestParam(value = "repositoryId") String repositoryId) {
        try {
            ResponseEntity responseEntity = permissionService.getUserBySearchUserIdAndRepositoryId(searchUserId,repositoryId);
            return bodyCheck(responseEntity);
        }catch(Exception e){
            e.printStackTrace();
            Map map = new HashMap();
            map.put("error", "NoBody");
            return (Map) new ResponseEntity(map, HttpStatus.EXPECTATION_FAILED);
        }
    }
     /**
     * instanceId에 대한 사용자와 repository 참여 정보를 가져를 검색하여 가져온다.
     * @param searchUserId
     * @return
     */
    @GetMapping("/searchInstanceId/{searchUserId}")
    @ResponseBody
    public Map getPermissionByInstanceIdAndSearchUserId(@PathVariable("searchUserId") String searchUserId, @RequestParam(value = "repositoryId") String repositoryId){
        try {
            String rtnInstanceid = getDetail().getInstanceId();
            ResponseEntity responseEntity = permissionService.getUserBySearchUserIdAndInstanceId(searchUserId, rtnInstanceid, repositoryId);
            return bodyCheck(responseEntity);
        }catch(Exception e){
            e.printStackTrace();
            Map map = new HashMap();
            map.put("error", "NoBody");
            return (Map) new ResponseEntity(map, HttpStatus.EXPECTATION_FAILED);
        }

    }
    @GetMapping("/instanceUser/")
    @ResponseBody
    public ResponseEntity getPermissionByInstanceId(HttpServletRequest request) {
        DashboardAuthenticationDetails user = (DashboardAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        String rtnInstanceid = user.getInstanceId();
        Map mapByRequest = Common.convertMapByRequest(request);
        ResponseEntity responseEntity = permissionService.getUserByInstanceId(rtnInstanceid, mapByRequest);
        return responseEntity;
    }

    private Map bodyCheck(ResponseEntity responseEntity ){
        if (responseEntity.getBody() != null) {
            return (Map) responseEntity.getBody();
        } else {
            Map map = new HashMap();
            map.put("error", "NoBody");
            return (Map) new ResponseEntity(map, HttpStatus.EXPECTATION_FAILED);
        }
    }
}