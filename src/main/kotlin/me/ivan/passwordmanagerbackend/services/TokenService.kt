package me.ivan.passwordmanagerbackend.services

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.philjay.jwt.*
import org.apache.tomcat.util.codec.binary.Base64
import org.springframework.stereotype.Service

@Service
class TokenService {
    private val decoder = object: Base64Decoder {
        override fun decode(bytes: ByteArray): ByteArray {
            return Base64.decodeBase64(bytes)
        }

        override fun decode(string: String): ByteArray {
            return Base64.decodeBase64(string)
        }

    }

    private val jsonDecoder = object: JsonDecoder<JWTAuthHeader, JWTAuthPayload> {
        private val gson = GsonBuilder().create()

        override fun headerFrom(json: String): JWTAuthHeader {
            return gson.fromJson(json, JWTAuthHeader::class.java)
        }

        override fun payloadFrom(json: String): JWTAuthPayload {
            return gson.fromJson(json, JWTAuthPayload::class.java)
        }

    }
}