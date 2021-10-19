package com.example.fundoonotesbackend.service;

import com.example.fundoonotesbackend.dto.LabelDTO;
import com.example.fundoonotesbackend.dto.ResponseDTO;

public interface ILabelService {

    ResponseDTO addLabel(String userIdToken, LabelDTO labelDTO);
    ResponseDTO updateLabel(String userIdToken, int labelId, LabelDTO labelDTO);
    ResponseDTO getAllLabelsByUser(String UserIdToken);
    ResponseDTO deleteLabel(String userIdToken, int labelId);
    ResponseDTO removeAllNotesByLabel(String userIdToken, int labelId);
    ResponseDTO deleteAllLabelByUser(String userIdToken);

}
