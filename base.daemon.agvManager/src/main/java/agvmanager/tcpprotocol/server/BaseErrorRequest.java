package agvmanager.tcpprotocol.server;

public abstract class BaseErrorRequest extends AgvManagerProtocolRequest{

    private final String errorDescription;

    protected BaseErrorRequest(final String request, final String errorDescription) {
        super(null, request);
        this.errorDescription = errorDescription;
    }

    protected BaseErrorRequest(final String request) {
        super(null, request);
        this.errorDescription = null;
    }

    @Override
    public String execute() {
        // nothing to do, just build the response
        return buildResponse();
    }

    protected String buildResponse() {
        final Object[] fields = {
                messageType(),
                request,
                errorDescription
        };
        final boolean[] mask = { false, true, true };
        return request;
        //return CsvRecord.valueOf(fields, mask).toString() + "\n";
    }

    protected abstract String messageType();
}
