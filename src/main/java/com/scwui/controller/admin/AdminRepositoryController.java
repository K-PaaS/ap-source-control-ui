package com.scwui.controller.admin;

import com.scwui.common.util.Common;
import com.scwui.controller.common.CommonController;
import com.scwui.service.admin.AdminRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lena on 2017-06-27.
 */
@SuppressWarnings("unchecked")
@Controller
@RequestMapping(value = "")
public class AdminRepositoryController extends CommonController {

    final AdminRepositoryService adminRepositoryService;

    @Autowired
    public AdminRepositoryController(AdminRepositoryService adminRepositoryService) {
        this.adminRepositoryService = adminRepositoryService;
    }

    /**
     *  레파지토리 목록 화면 초기 설정
     * @param instanceid
     * @param map
     * @param request
     * @param session
     * @return
     * @throws Exception
     * @author 이인정
     * @since 2017.07.01
     */
    @RequestMapping("/admin/repository/{instanceId}")
    public ModelAndView repositoryListForAdmin(@PathVariable("instanceId") String instanceid,
                                               @RequestParam Map map,
                                               HttpServletRequest request, HttpSession session) throws Exception
    {
        // Source Control Api Server 호출 - repository 목록 조회
        String username = (String) Common.NotNullrtnByobj(session.getAttribute("name"),"");
        session.setAttribute("instanceId", instanceid);
//        Common.convertMapByRequest(request,map);
//        List<Repository> repositories = adminRepositoryService.getAdminRepositories(instanceid, map);
        map.put("username", username);
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("repositories", repositories);
        modelAndView.addObject("userid", username);
        modelAndView.addObject("title", "레파지토리목록");
        modelAndView.setViewName("/admin/repository/repositoryList");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/admin/repository/repositoryList")
    public Map repositoryListForAdminByParam(@RequestParam Map map, HttpSession session)
    {
        // Source Control Api Server 호출 - repository 목록 조회
        String instanceid = (String)session.getAttribute("instanceId");
        map.put("username", session.getAttribute("name"));

        Map rtnMap = new HashMap();
        ResponseEntity<Map> response = adminRepositoryService.getAdminRepositories(instanceid, map);
        Map pageInfo = (Map)response.getBody().get("pageInfo");
        rtnMap.put("repositories", response.getBody().get("repositories"));
        rtnMap.put("pageInfo", pageInfo.size());
        rtnMap.put("repoName", map.getOrDefault("repoName",""));
        return rtnMap;
    }
}





