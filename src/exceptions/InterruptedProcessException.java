package exceptions;

import enums.ProcessEnum;

public class InterruptedProcessException extends Exception{
    private ProcessEnum process;

    public InterruptedProcessException(ProcessEnum process){
        this.process = process;
    }

    public InterruptedProcessException(String message, ProcessEnum process) {
        super(message);
        this.process = process;
    }

    public ProcessEnum getProcess() {
        return process;
    }
}
