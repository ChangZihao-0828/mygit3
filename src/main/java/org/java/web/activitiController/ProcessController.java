package org.java.web.activitiController;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @Auther: 昌子豪
 * @Date: 2019/7/14 14:33
 * @Description: Frighting!!!
 */


@Controller
public class ProcessController {

    @Autowired
    private RepositoryService repositoryService;


    /**
     *
     * 得到文件名，文件输入流
     * 根据repositoryservice的createdeloyment
     * 添加对于文件名及文件输入流，在使用deploy方法上传
     * @param
     * @param
     * @return
     * @throws IOException
     */
    @PostMapping("deploye")
    public String deploy(@PathVariable("bpmn") MultipartFile bpmn, @PathVariable("png") MultipartFile png) throws IOException {


                String pngName = png.getOriginalFilename();

                InputStream pngin = png.getInputStream();


                String bpmnName = bpmn.getOriginalFilename();

                InputStream bpmnin = bpmn.getInputStream();


        DeploymentBuilder deployment = repositoryService.createDeployment();

        deployment.addInputStream(bpmnName,bpmnin).addInputStream(pngName,pngin).deploy();

        return "redirect:/processDefinition";
    }

    /**
     * 根据repositoryservice得到流程定义查询对象
     * 根据对象的list方法查询到数据
     * 显示到页面
     *
     * @param model
     * @return
     */
    @GetMapping("processDefinition")
    public String processDefinition(Model model){

        ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();

        List<ProcessDefinition> list = query.list();

        model.addAttribute("list",list);

        return "/activitiFlow/showProcessDefinition";


    }

    /**
     * 删除流程定义，上传bpmn和png问件时，工作流随机生成文件id，
     * 流程定义用到的服务为repository.service删除文件
     * @param deploymentId
     * @return
     */
    @GetMapping("del/{deploymentId}")
    public String delete(@PathVariable("deploymentId") String deploymentId){

        repositoryService.deleteDeployment(deploymentId,true);

        return "redirect:/processDefinition";

    }


    /**
     * 根据文件id及图片名，下载流程图
     * @param
     * @param
     * @throws IOException
     */
    @GetMapping("showResource/{deploymentId}/{name}")
    public void showResource(@PathVariable("deploymentId") String deploymentId, @PathVariable("name") String name, HttpServletResponse res) throws IOException {

        InputStream in = repositoryService.getResourceAsStream(deploymentId, name);

        OutputStream out = res.getOutputStream();

        byte[] b = new byte[8192];

        int len = 0;

        while((len=in.read(b,0,8192))!=-1){

            out.write(b,0,len);
        }

        out.close();

        in.close();
    }





}
