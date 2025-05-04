package org.firstinspires.ftc.teamcode;

import java.util.function.Supplier;

/**
 * This is the Process class for Project Overload. This class represents processes that can
 * be run by subsystems, allowing subsystems to properly handle object dependencies as well
 * as properly queue multiple processes.
 *
 * @author Asher Childress - 9161 Overload
 */
public class Process {
    enum ProcessStatus {
        NOT_STARTED("Not Started"),
        RUNNING("Running"),
        COMPLETED("Completed"),
        FAILED("Failed"),
        PAUSED("Paused"),
        TIMED_OUT("Timed Out");
    }
    private String name;
    private ProcessStatus status;
    private Timer timer;
    private Supplier<ProcessStatus> statusChecker;
    private double timeoutSeconds;
    private boolean useTimeout;
    
   /**
     * Constructor with a custom status checker and optional timeout.
     * 
     * @param name The name of the process
     * @param statusChecker Function that returns the current status
     * @param timeoutSeconds The timeout period in seconds (0 for no timeout)
     */
    public Process(String name, Supplier<ProcessStatus> statusChecker, double timeoutSeconds) {
        this.name = name;
        this.status = ProcessStatus.NOT_STARTED;
        this.statusChecker = statusChecker;
        this.timer = new Timer();
        this.timeoutSeconds = timeoutSeconds;
        this.useTimeout = timeoutSeconds > 0;
    }
    /**
     * Get the current status of the process, checking for timeout if applicable.
     * 
     * @return The current ProcessStatus
     */
    public ProcessStatus getStatus() {
        // First check if we're using timeout and if we've exceeded it
        if (useTimeout && status == ProcessStatus.RUNNING && timer.getTimeSeconds() > timeoutSeconds) {
            status = ProcessStatus.TIMED_OUT;
            return status;
        }
        // Then check the custom status checker if available
        if (statusChecker != null) {
            ProcessStatus checkedStatus = statusChecker.get();
            if (checkedStatus != status) {
                status = checkedStatus;
            }
        }
        
        return status;
    }
    public void setStatus(ProcessStatus status) {
        this.status = status;
    }
    /**
     * Start a specific process.
     * 
     * @param processName The name of the process to start
     */
    public void startProcess(String processName) {
      TimedProcess process = processes.get(processName);
      if (process != null) {
          process.start();
      }
    }
    /**
     * Remove a process from monitoring.
     * 
     * @param processName The name of the process to remove
     * @return The removed process, or null if not found
     */
    public TimedProcess removeProcess(String processName) {
        return processes.remove(processName);
    }
    /**
     * Check if the process is done (completed, failed, or timed out).
     * 
     * @return true if the process is done, false otherwise
     */
    public boolean isDone() {
        ProcessStatus currentStatus = getStatus();
        return currentStatus == ProcessStatus.COMPLETED || 
               currentStatus == ProcessStatus.FAILED ||
               currentStatus == ProcessStatus.TIMED_OUT;
    }
}
