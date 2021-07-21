package com.green.chodoori;

import java.io.IOException;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

@SpringBootTest
public class ImageUploadTest {

	@Value("${upload.path}")
	private String path;
	
	@Test
	public void test() throws IOException {
		
		
		
		
	}
}
