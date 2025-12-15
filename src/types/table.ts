export interface TableEntry {
  id: string;
  project: string;
  client: string;
  status: 'completed' | 'in-progress' | 'pending' | 'cancelled';
  progress: number;
  amount: string;
  date: string;
}

export type StatusType = TableEntry['status'];
