import { StatusType } from '../types/table';

export const STATUS_CONFIG: Record<StatusType, { label: string; className: string }> = {
  'completed': {
    label: 'Completed',
    className: 'bg-green-100 text-green-700',
  },
  'in-progress': {
    label: 'In Progress',
    className: 'bg-blue-100 text-blue-700',
  },
  'pending': {
    label: 'Pending',
    className: 'bg-yellow-100 text-yellow-700',
  },
  'cancelled': {
    label: 'Cancelled',
    className: 'bg-red-100 text-red-700',
  },
};
