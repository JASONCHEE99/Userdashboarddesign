import { StatusType } from '../../types/table';
import { STATUS_CONFIG } from '../../config/statusConfig';

interface StatusBadgeProps {
  status: StatusType;
}

export function StatusBadge({ status }: StatusBadgeProps) {
  const config = STATUS_CONFIG[status];

  return (
    <span className={`px-3 py-1 rounded-full ${config.className}`}>
      {config.label}
    </span>
  );
}
