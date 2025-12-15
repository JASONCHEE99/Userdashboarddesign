interface ProgressBarProps {
  progress: number;
  maxWidth?: string;
  color?: string;
}

export function ProgressBar({ 
  progress, 
  maxWidth = '100px',
  color = 'bg-blue-600' 
}: ProgressBarProps) {
  return (
    <div className="flex items-center gap-3">
      <div className="flex-1 bg-gray-200 rounded-full h-2" style={{ maxWidth }}>
        <div 
          className={`${color} h-2 rounded-full transition-all`}
          style={{ width: `${progress}%` }}
        />
      </div>
      <span className="text-gray-600">{progress}%</span>
    </div>
  );
}
