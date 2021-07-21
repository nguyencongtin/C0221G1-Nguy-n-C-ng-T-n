package com.case_study.controller;

import com.case_study.model.dto.QuestionDto;
import com.case_study.model.entity.question.Question;
import com.case_study.model.service.IQuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    IQuestionService iQuestionService;
    @GetMapping({"","/search"})
    public ModelAndView showList(@RequestParam("title") Optional<String> title,
                                 @RequestParam("name")Optional<String> name,
                                 @PageableDefault(value=2) Pageable pageable){
        return new ModelAndView("question/list","questions",iQuestionService.findAll(title.orElse(""),name.orElse(""),pageable)).
                addObject("title",title.orElse(""))
                .addObject("name",name.orElse(""));
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        return new ModelAndView("question/create","questionDto",new QuestionDto()).
                addObject("questionsType",iQuestionService.findAllQuestionType());
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute @Valid QuestionDto questionDto, BindingResult bindingResult){
        new QuestionDto().validate(questionDto,bindingResult);
        if(bindingResult.hasErrors()){
            return new ModelAndView("question/create","msg","Something wrong!! <br> Try again").
                    addObject("questions",iQuestionService.findAllQuestionType());
        }
        Question question=new Question();
        BeanUtils.copyProperties(questionDto,question);
        iQuestionService.save(question);
        return new ModelAndView("question/create","msg","Create is successful!!").
                addObject("questions",iQuestionService.findAllQuestionType());
    }
    @GetMapping("/edit/{idc}")
    public ModelAndView showEdit(@PathVariable Long idc){
        if (iQuestionService.findById(idc)==null){
            return new ModelAndView("error-404");
        }
        QuestionDto questionDto =new QuestionDto();
        BeanUtils.copyProperties(iQuestionService.findById(idc),questionDto);

        return new ModelAndView("question/edit","questionDto",questionDto).
                addObject("questions",iQuestionService.findAllQuestionType());
    }
    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute @Valid QuestionDto questionDto,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ModelAndView("question/edit","msg","Something wrong!! <br> Try again").
                    addObject("questions",iQuestionService.findAllQuestionType());
        }
        Question question=new Question();
        BeanUtils.copyProperties(questionDto,question);
        iQuestionService.save(question);
        return new ModelAndView("question/edit","msg","Edit is successful!!").
                addObject("questions",iQuestionService.findAllQuestionType());
    }
    @PostMapping("/delete")
    public ModelAndView delete(@RequestParam Optional<List<Long>> id ){
        if (id.isPresent()){
            for (Long i : id.get()){
                Question question= iQuestionService.findById(i);
                if (question==null){
                    return new ModelAndView("error-404");
                }
                question.setFlag(true);
                iQuestionService.save(question);
                return new ModelAndView("redirect:/question");
            }
        }
        return new ModelAndView("redirect:/question");
    }

}
