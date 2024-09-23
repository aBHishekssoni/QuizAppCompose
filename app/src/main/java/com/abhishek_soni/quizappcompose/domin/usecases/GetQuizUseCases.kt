package com.abhishek_soni.quizappcompose.domin.usecases

import com.abhishek_soni.quizappcompose.common.Resource
import com.abhishek_soni.quizappcompose.domin.model.Quiz
import com.abhishek_soni.quizappcompose.domin.repository.QuizRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetQuizUseCases(
    val quizRepository: QuizRepository
) {
   operator fun invoke(
        amount: Int,
        category: Int,
        difficulty: String,
        type: String
    ): Flow<Resource<List<Quiz>>> =flow{

        emit(Resource.Loading())

       try {
           emit(Resource.Success(data = quizRepository.geiQuizzes(amount, category, difficulty, type)))
       }catch (e: Exception){
           emit(Resource.Error(message = e.message.toString()))
       }

   }.flowOn(Dispatchers.IO)
}