package com.phonegap.plugins.microblink.recognizers.serialization;

import com.microblink.entities.recognizers.Recognizer;
import com.phonegap.plugins.microblink.recognizers.RecognizerSerialization;

import org.json.JSONException;
import org.json.JSONObject;

public final class GermanyIdFrontRecognizerSerialization implements RecognizerSerialization {

    @Override
    public Recognizer<?, ?> createRecognizer(JSONObject jsonRecognizer) {
        com.microblink.entities.recognizers.blinkid.germany.GermanyIdFrontRecognizer recognizer = new com.microblink.entities.recognizers.blinkid.germany.GermanyIdFrontRecognizer();
        recognizer.setDetectGlare(jsonRecognizer.optBoolean("detectGlare", true));
        recognizer.setExtractCanNumber(jsonRecognizer.optBoolean("extractCanNumber", true));
        recognizer.setExtractDateOfExpiry(jsonRecognizer.optBoolean("extractDateOfExpiry", true));
        recognizer.setExtractDocumentNumber(jsonRecognizer.optBoolean("extractDocumentNumber", true));
        recognizer.setExtractGivenNames(jsonRecognizer.optBoolean("extractGivenNames", true));
        recognizer.setExtractNationality(jsonRecognizer.optBoolean("extractNationality", true));
        recognizer.setExtractPlaceOfBirth(jsonRecognizer.optBoolean("extractPlaceOfBirth", true));
        recognizer.setExtractSurname(jsonRecognizer.optBoolean("extractSurname", true));
        recognizer.setFaceImageDpi(jsonRecognizer.optInt("faceImageDpi", 250));
        recognizer.setFullDocumentImageDpi(jsonRecognizer.optInt("fullDocumentImageDpi", 250));
        recognizer.setFullDocumentImageExtensionFactors(BlinkIDSerializationUtils.deserializeExtensionFactors(jsonRecognizer.optJSONObject("fullDocumentImageExtensionFactors")));
        recognizer.setReturnFaceImage(jsonRecognizer.optBoolean("returnFaceImage", false));
        recognizer.setReturnFullDocumentImage(jsonRecognizer.optBoolean("returnFullDocumentImage", false));
        recognizer.setReturnSignatureImage(jsonRecognizer.optBoolean("returnSignatureImage", false));
        recognizer.setSignatureImageDpi(jsonRecognizer.optInt("signatureImageDpi", 250));
        return recognizer;
    }

    @Override
    public JSONObject serializeResult(Recognizer<?, ?> recognizer) {
        com.microblink.entities.recognizers.blinkid.germany.GermanyIdFrontRecognizer.Result result = ((com.microblink.entities.recognizers.blinkid.germany.GermanyIdFrontRecognizer)recognizer).getResult();
        JSONObject jsonResult = new JSONObject();
        try {
            SerializationUtils.addCommonResultData(jsonResult, result);
            jsonResult.put("canNumber", result.getCanNumber());
            jsonResult.put("dateOfBirth", SerializationUtils.serializeDate(result.getDateOfBirth()));
            jsonResult.put("dateOfExpiry", SerializationUtils.serializeDate(result.getDateOfExpiry()));
            jsonResult.put("documentNumber", result.getDocumentNumber());
            jsonResult.put("faceImage", SerializationUtils.encodeImageBase64(result.getFaceImage()));
            jsonResult.put("fullDocumentImage", SerializationUtils.encodeImageBase64(result.getFullDocumentImage()));
            jsonResult.put("givenNames", result.getGivenNames());
            jsonResult.put("nationality", result.getNationality());
            jsonResult.put("placeOfBirth", result.getPlaceOfBirth());
            jsonResult.put("signatureImage", SerializationUtils.encodeImageBase64(result.getSignatureImage()));
            jsonResult.put("surname", result.getSurname());
        } catch (JSONException e) {
            // see https://developer.android.com/reference/org/json/JSONException
            throw new RuntimeException(e);
        }
        return jsonResult;
    }

    @Override
    public String getJsonName() {
        return "GermanyIdFrontRecognizer";
    }

    @Override
    public Class<?> getRecognizerClass() {
        return com.microblink.entities.recognizers.blinkid.germany.GermanyIdFrontRecognizer.class;
    }
}