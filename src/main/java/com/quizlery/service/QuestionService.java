package com.quizlery.service;

import com.quizlery.dto.QuestionDto;
import com.quizlery.dto.QuizDto;
import com.quizlery.model.Question;
import com.quizlery.model.Quiz;
import com.quizlery.repository.QuestionRepo;
import com.quizlery.repository.QuizRepo;
import com.quizlery.service.Inter.QuestionServiceInter;
import com.quizlery.service.Inter.QuizServiceInter;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService implements QuestionServiceInter {

    private final QuestionRepo questionRepo;
    private final ModelMapper modelMapper;


    @Override
    public QuestionDto findQuestionById(Integer id) {
        Optional<Question> questionOptional = questionRepo.findById(id);
        if (questionOptional.isPresent()){
            QuestionDto questionDto = modelMapper.map(questionOptional.get(), QuestionDto.class);
            return questionDto;
        }
        throw new  EntityNotFoundException("Not Found Question");
    }

    @Override
    public List<QuestionDto> findAll() {
        List<Question> questions = questionRepo.findAll();
        return questions.stream()
                .map(question -> modelMapper.map(question, QuestionDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public QuestionDto createQuestion(QuestionDto questionDto) {
        Question question = modelMapper.map(questionDto, Question.class);
        Question saved = questionRepo.save(question);
        return modelMapper.map(saved, QuestionDto.class);
    }

    @Override
    public QuestionDto updateQuestion(QuestionDto questionDto, Integer id) {
        Optional<Question> questionOptional = questionRepo.findById(id);
        if (questionOptional.isPresent()){
            Question question = modelMapper.map(questionDto, Question.class);
            question.setId(id);
            Question updated = questionRepo.save(question);
            return modelMapper.map(updated, QuestionDto.class);

        }
        throw new  EntityNotFoundException("Not Found Question");
    }

    @Override
    public void deleteQuestionById(Integer id) {
        Optional<Question> questionOptional = questionRepo.findById(id);
        if (questionOptional.isPresent()){
            questionRepo.deleteById(id);

        }else {
            throw new EntityNotFoundException("Not Found Question");
        }
    }
}
