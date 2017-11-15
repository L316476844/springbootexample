package org.jon.lv;

import org.jon.lv.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;


public class MockitoExampleTest extends SpringbootexampleApplicationTests  {

  //  @Mock //需要mock的bean
  //  private UserService userService;

  //  @Autowired
   // @InjectMocks //被注入mock对象的类一般是被测试类
   // private UserAO userAO;


   // @Before
  //  public void setUp() {
   //     MockitoAnnotations.initMocks(this);
   //     Mockito.when(userService.getUserByName("zhangsan")).thenReturn("zhangsan");
        // 方法调用时，如果不想指定一个明确的参数，就可以用下面这样的写法来表示任意的参数。
   //     Mockito.when(userService.getUserByName(Matchers.anyString())).thenReturn("zhangsan");
   // }

   // @Test
  //  public void getUserByName() throws Exception {
  //      System.out.println("----------------------");
  //      System.out.println("----------------------" + userAO.getUserByName("lisi"));
  //      Assert.assertTrue(userAO.getUserByName("lisi").equals("zhangsan"));
   //     System.out.println("----------------------");
  //  }

}
