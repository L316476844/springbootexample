import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Description: 描述
 * Copyright: Copyright (c) 2017
 * @author lv bin
 * Version: V1.0.0
 */
public class MockitoControllerExampleTest {
    
   // public MockMvc mockMvc;

  //  @InjectMocks
  //  private FileController fileController;

  //  @Mock
  //  private FileService fileService;

  //  @Before
  //  public void init(){
  //    MockitoAnnotations.initMocks(this);
        //构造MockMvc
  //      mockMvc = MockMvcBuilders.standaloneSetup(fileController).build();
  //  }

  //  @Test
  //  public void avatar() throws Exception {
   //     Mockito.when(fileService.upload(Matchers.anyObject(), Matchers.anyString())).thenReturn(new String());

    //    InputStream inputStream = new ByteArrayInputStream(new String("test").getBytes());
    //    mockMvc.perform(
    //            MockMvcRequestBuilders.fileUpload("/file").
    //                    file(new MockMultipartFile("file", inputStream)).
    //                    header(TOKEN_NAME, token).header(UID, uid))
    //            .andExpect(MockMvcResultMatchers.status().isOk())
     //           .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
     //           .andExpect(MockMvcResultMatchers.content().json("{\"code\":\"000000\",\"message\":\"success\",\"data\":\"\"}"))
      //          .andDo(MockMvcResultHandlers.print()).andReturn();

   // }
}
