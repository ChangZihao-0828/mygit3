package org.java;

import org.activiti.engine.IdentityService;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TmssystemApplicationTests {

    @Test
    public void contextLoads() {

        System.out.println("hello");
    }

    private final String pwd = "123456";
    @Test
    public void list() {
        Md5Hash md5 = new Md5Hash(pwd,"d102",5);
        System.out.println("加密后的结果是:"+md5.toString());
        //e9bf6ea1290f43204d9733664f2dc6a7
    }

    @Autowired
    private IdentityService identityService;
    @Test
    public void configGroup(){

        //创建组
        String groupId="10"; //组的编号
        //判断组的编号是否已经存在，不存在，才创建组
        if(identityService.createGroupQuery().groupId(groupId).singleResult()==null){
            //创建组
            GroupEntity group = new GroupEntity();
            group.setId(groupId);//组的id
            group.setName("客户组");//组名

            identityService.saveGroup(group);//保存组
        }

        //创建员工
        String userId="jack";//员工编号
        //判断员工编号是否已存在,不存在，才创建
        if(identityService.createUserQuery().userId(userId).singleResult()==null){
            //创建员工
            UserEntity user = new UserEntity();
            user.setId(userId);//员工编号
            user.setFirstName("jack");//员工名称

            identityService.saveUser(user);
        }

//        use在员工与组之间，建立关联
        //如果有关系，就删除之前的关系再创建新关系，如果不存在，就创建新关系
        identityService.deleteMembership(userId, groupId);//删除关系
        identityService.createMembership(userId, groupId);//建立关系


        System.out.println("配置成功");
    }
}
