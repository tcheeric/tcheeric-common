package xyz.tcheeric.common.rest;

import java.io.IOException;

public interface Request<T extends Request.Param, U extends Response> {

    default U getResponse() {
        return null;
    }

    interface Param {
        enum Kind {
            PATH, QUERY
        }

        default Kind getKind() {
            return Kind.PATH;
        }
    }
}