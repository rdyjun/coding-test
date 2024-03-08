import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int solution(int[][] jobs) throws Exception {
        int answer = 0;
        int jobCount = jobs.length;
        int processedJobCount = 0;
        int processTime = 0;
        int nextProcessEndTime = 0;
        boolean nowProcessing = false;
        
        PriorityQueue<Job> jobQueue = new PriorityQueue<>();
        for (int i = 0; i < jobCount; i++) {
            jobQueue.add(new Job(jobs[i][0], jobs[i][1]));
        }
        
        PriorityQueue<Job> processing = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                return Integer.compare(j1.getProcessingTime(), j2.getProcessingTime());
            }
        });
        
        while (processedJobCount < jobCount) {
            if (nowProcessing && nextProcessEndTime == processTime) {
                nowProcessing = false;
            }
            
            while (!jobQueue.isEmpty()) {
                Job next = jobQueue.peek();
                

                if (next.getStart() > processTime) {
                    break;
                }
                
                processing.add(jobQueue.poll());
            }
            
            if (!nowProcessing && !processing.isEmpty()) {
                Job now = processing.poll();
                nextProcessEndTime = processTime + now.getProcessingTime();
                nowProcessing = true;
                
                answer += nextProcessEndTime - now.getStart();
                processedJobCount++;
            }
            
            processTime++;
        }
        return answer / jobCount;
    }
    
    class Job implements Comparable<Job> {
        
        private Integer start;
        
        private Integer processingTime;
        
        public Job(int start, int processingTime) {
            this.start = start;
            this.processingTime = processingTime;
        }
        
        public Integer getStart() {
            return this.start;
        }
        
        public Integer getProcessingTime() {
            return this.processingTime;
        }
        
        @Override
        public int compareTo(Job job) {
            return Integer.compare(this.start, job.start);
        }
    }
}