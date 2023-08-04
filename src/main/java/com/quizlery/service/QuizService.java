package com.quizlery.service;

import com.quizlery.dto.QuizDto;
import com.quizlery.exception.EntityNotFoundException;
import com.quizlery.model.Quiz;
import com.quizlery.repository.QuizRepo;
import com.quizlery.service.Inter.QuizServiceInter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizService implements QuizServiceInter {

    private final QuizRepo quizRepo;
    private final ModelMapper modelMapper;


    @Override
    public QuizDto findQuizById(Integer id) {
        Optional<Quiz> quizOptional = quizRepo.findById(id);
        if (quizOptional.isPresent()){
            QuizDto quizDto = modelMapper.map(quizOptional.get(), QuizDto.class);
            return quizDto;
        }
        throw new  EntityNotFoundException("Not Found Quiz");
    }

    @Override
    public QuizDto findQuizByTitle(String title) {
        Optional<Quiz> quizOptional = quizRepo.findByTitle(title);
        if (quizOptional.isPresent()){
            QuizDto quizDto = modelMapper.map(quizOptional.get(), QuizDto.class);
            return quizDto;
        }
        throw new EntityNotFoundException("Not Found Quiz");
    }

    @Override
    public List<QuizDto> findAll() {
        List<Quiz> quizList = quizRepo.findAll();
        List<QuizDto> quizDtoList = quizList.stream()
                                        .map(quiz -> modelMapper.map(quiz, QuizDto.class))
                                        .collect(Collectors.toList());
        return quizDtoList;
    }

    @Override
    public QuizDto createQuiz(QuizDto quizDto) {
        Quiz quiz = modelMapper.map(quizDto, Quiz.class);
        Quiz saved = quizRepo.save(quiz);
        return modelMapper.map(saved, QuizDto.class);
    }

    @Override
    public QuizDto updateQuiz(QuizDto quizDto, Integer id) {
        Optional<Quiz> quizOptional = quizRepo.findById(id);
        if (quizOptional.isPresent()){
            Quiz existingQuiz = quizOptional.get();;
            modelMapper.map(quizDto, existingQuiz);
            Quiz updatedQuiz =quizRepo.save(existingQuiz);
            return modelMapper.map(updatedQuiz, QuizDto.class);
        }
        throw new  EntityNotFoundException("Not Found Quiz");
    }

    @Override
    public void deleteQuizById(Integer id) {
        Optional<Quiz> quizOptional = quizRepo.findById(id);
        if (quizOptional.isPresent()){
            quizRepo.deleteById(id);
        }else{
            throw new  EntityNotFoundException("Not Found Quiz");
        }
    }

    @Override
    public List<QuizDto> findByDifficultyLevel(String level) {
        List<Quiz> quizList = quizRepo.findByDifficultyLevel(level);
        List<QuizDto> quizDtoList = quizList.stream()
                .map(quiz -> modelMapper.map(quiz, QuizDto.class))
                .collect(Collectors.toList());
        return quizDtoList;
    }

    @Override
    public List<String> findAllCategories() {
        return quizRepo.findAllCategories();
    }
}
