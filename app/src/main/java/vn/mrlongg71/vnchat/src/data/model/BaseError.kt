package vn.mrlongg71.vnchat.src.data.model
import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

//
//object ErrorUtils {
//    fun parseError(response: Response<*>): ErrorResponse {
//        val converter: Converter<ResponseBody, ErrorResponse> = APIVnChat.
//            .responseBodyConverter(ErrorResponse::class.java, arrayOfNulls<Annotation>(0))
//        val errorResponse: ErrorResponse
//        errorResponse = try {
//            assert(response.errorBody() != null)
//            converter.convert(response.errorBody())
//        } catch (e: IOException) {
//            return ErrorResponse()
//        }
//        return errorResponse
//  }
//}