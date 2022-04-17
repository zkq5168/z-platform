package com.zkq.platform.code.web;

import com.zkq.platform.code.entity.dto.CodeGeneratorDTO;
import com.zkq.platform.code.service.ICodeService;
import com.zkq.platform.webcommon.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * 代码控制器
 * @author zkq
 * @date 2022-04-14
 */
@RestController
@RequestMapping("/code")
public class CodeController {
    @Autowired
    private ICodeService codeService;


    /**
     * 生成代码
     * @param codeGeneratorDTO
     * @return
     * @throws IOException
     */
    @PostMapping("/generate")
    public Result generate(@RequestBody CodeGeneratorDTO codeGeneratorDTO) {
        codeService.generate(codeGeneratorDTO);
        return Result.success();
    }
}
