package com.jayus.lioj.judge.codesandbox;

import com.jayus.lioj.judge.codesandbox.impl.ExampleCodeSandbox;
import com.jayus.lioj.judge.codesandbox.impl.RemoteCodeSandbox;
import com.jayus.lioj.judge.codesandbox.model.ExecuteCodeRequest;
import com.jayus.lioj.judge.codesandbox.model.ExecuteCodeResponse;
import com.jayus.lioj.model.enums.QuestionSubmitLanguageEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CodeSandboxTest {

    @Test
    void executeCode() {
        CodeSandbox codeSandbox = new ExampleCodeSandbox();
        String code = "int main() { }";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }
}